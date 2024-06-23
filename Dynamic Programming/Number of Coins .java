
class Solution{

	public int minCoins(int coins[], int M, int V){ 
	    // Your code goes here
	    
	    int[][] dp = new int[M][V+1];
	    for( int x[] : dp ) Arrays.fill(x , -1);
	    
	   // int ans = helper( M-1 , V , coins , dp);
	   // return ans == (int)1e8 ? -1 : ans;
	   
	   // Tabulation :-
	    
	        for( int i=0 ; i <= V ; i++ ){
	            if( i % coins[0] == 0) dp[0][i] = i/coins[0];
	            else dp[0][i] = (int) 1e8;
	        }
	        
	        for( int i=1 ; i < M ; i++ ){
	            for( int j = 0 ; j <= V ; j++){
	                
	                int notTake = 0 + dp[i-1][j];
            	    int take = (int) 1e8;
            	    if( coins[i] <= j ) take = 1 + dp[i][j-coins[i]];
            	    
            	    dp[i][j] = Math.min( notTake , take);
	            }
	        }
	        return dp[M-1][V] == (int)1e8 ? -1 : dp[M-1][V];
	        
	} 
	
	
	public int helper( int ind  , int target , int[] coins , int[][] dp){
	    
	    // Base Cases :-
	    if( ind == 0 ){
	        if( target % coins[0] == 0 ) return target/coins[0];
	        return (int) 1e8;
	    }
	    if( target == coins[ind] ) return 1;
	    
	    if( dp[ind][target] != -1 ) return dp[ind][target];
	    
	    int notTake = 0 + helper( ind-1 , target, coins , dp);
	    int take = (int) 1e8;
	    if( coins[ind] <= target ) take = 1 + helper( ind , target-coins[ind] , coins , dp);
	    
	    return dp[ind][target] =  Math.min( notTake , take);
	}
}
