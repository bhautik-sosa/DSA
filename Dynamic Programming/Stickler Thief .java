
class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n){
        // Your code here
        // int[] dp = new int[n+1];
        // Arrays.fill(dp , -1);
        // return helper( n-1 , arr , dp);
        
        // Tabulation :-
            
            // dp[0] = arr[0];
            // for( int i=1 ; i < n ; i++ ){
                
            //     int pick = arr[i];
            //     if( i > 1) pick += dp[i-2];
            //     int nonPick = dp[i-1];
                
            //     dp[i] = Math.max( pick , nonPick);
            // }
            // return dp[n-1];
            
        // Space Optimized :-
            
            int prev = arr[0];
            int prev2 = 0;
            
            for( int i=1 ; i < n ; i++ ){
                
                int pick = arr[i] + prev2;
                int nonPick = prev;
                
                int cur = Math.max( pick , nonPick );
                
                prev2 = prev;
                prev = cur;
            }
            
            return prev;
            
    }
    
    // Memonrization :- 
    
        // public int helper( int ind , int[] arr , int[] dp){
            
        //     if( ind < 0 ) return 0;
            
        //     if( ind == 0 ) return arr[ind];
            
        //     if( dp[ind] != -1 ) return dp[ind];
            
        //     int pick = arr[ind] + helper( ind-2 , arr , dp);
        //     int nonPick = 0 + helper(ind-1 , arr , dp);
            
        //     return dp[ind] = Math.max( pick , nonPick);
        // }
}
