
class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        // long[][] dp = new long[N][sum+1];
        // for( long x[] : dp ) Arrays.fill(x , -1);
        
        // return helper(N-1 , sum , coins , dp);
        
        // Tabulation :-
            
            // for( int i=0 ; i <= sum ; i++ ){
                
            //     if( (long) i % coins[0] == 0 ) dp[0][i] = 1;
            //     else dp[0][i] = 0;
            // }
            
            // for( int i=1 ; i < N ; i++){
            //     for( int j =0 ; j <= sum ; j++ ){
                    
            //         long notTake = dp[i-1][j];
            //         long take = 0;
            //         if( j >= coins[i]) take = dp[i][j-coins[i]];
                    
            //         dp[i][j] = take + notTake;
            //     }
            // }
            // return dp[N-1][sum];
            
        // Space Optimization :-
        
            long[] prev = new long[sum+1];
            
            for( int i=0 ; i <= sum ; i++ ){
                
                if( (long) i % coins[0] == 0 ) prev[i] = 1;
                else prev[i] = 0;
            }
            
            for( int i=1 ; i < N ; i++){
                
                long[] cur = new long[sum+1];
                for( int j =0 ; j <= sum ; j++ ){
                    
                    long notTake = prev[j];
                    long take = 0;
                    if( j >= coins[i]) take = cur[j-coins[i]];
                    
                   cur[j] = take + notTake;
                }
                prev = cur;
            }
            return prev[sum];
            
    }
    
    public long helper( int ind , int sum ,  int[] coins , long[][] dp){
        
        // Base cases :-
        if( ind == 0 ){
            if( sum % coins[0] == 0 ) return 1;
            return 0;
        }
        
        if( dp[ind][sum] != -1 ) return dp[ind][sum];
        
        long notTake = helper(ind-1 , sum , coins , dp);
        long take = 0 ;
        if( sum >= coins[ind]) take = helper(ind , sum-coins[ind] , coins, dp);
        
        return dp[ind][sum] = take + notTake;
    }
}
