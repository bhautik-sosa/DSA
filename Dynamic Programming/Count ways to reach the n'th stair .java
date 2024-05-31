
class Solution{
    //Function to count number of ways to reach the nth stair.
    int mod = 1000000007;
    int countWays(int n){
        
        // --> Memoization :-
        
            // int[] dp = new int[n+1];
            // Arrays.fill( dp , -1);
            // return helper( n , dp) % mod;
        
        // Tabulation :-
        
            // int[] dp = new int[n+1];
            // dp[0] = dp[1] = 1;
            
            // for( int i=2 ; i <= n ; i++ ) {
            //     dp[i] = dp[i-1]%mod + dp[i-2]%mod;
            // }
            
            // return dp[n]%mod;
            
        // Space Optimized :-
            
            int prev = 1 , prev2 = 1;
            int cur;
            for( int i=2 ; i <= n ; i++ ){
                cur = prev%mod + prev2 % mod;
                prev2 = prev;
                prev = cur;
            }
            
            return prev % mod;
    }
    
    // --> Memoization :-
    
        // public int helper( int n , int[] dp){
            
        //     if(n == 0 ) return 1;
        //     if( n == 1 ) return 1;
            
        //     if( dp[n] != -1 ) return dp[n];
            
        //     return dp[n] = helper(n-1 , dp)%mod + helper(n-2 , dp)%mod;
        // }
}
