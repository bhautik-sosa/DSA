

class Solution{

	public int minDifference(int arr[], int n){ 
	    // Your code goes here
	    
	    int sum = 0;
	    for( int x : arr ) sum += x;
	    
	    boolean[][] dp = new boolean[n][sum+1];
	    
	    for( int i=0 ; i < n ; i++ ) dp[i][0] = true;
	    
	    dp[0][arr[0]] = true;
	    
	    for( int i= 1 ; i < n ; i++ ){
	        
	        for( int j = 1 ; j <= sum ; j++ ){
	            
	            boolean take = false;
	            if( arr[i] <= j ) take = dp[i-1][j-arr[i]];
	            boolean notTake = dp[i-1][j];
	            
	            dp[i][j] = take || notTake;
	        }
	    }
	    
	    int minDiff = Integer.MAX_VALUE;
	    for( int i=0 ; i <= sum ; i++ ){
	        
	        if( dp[n-1][i] ){
	            
	            int s1 = i;
	            int s2 = sum - s1;
	            
	            minDiff = Math.min( minDiff , Math.abs( s1 -s2));
	        }
	    }
	    
	    return minDiff;
	} 

}
