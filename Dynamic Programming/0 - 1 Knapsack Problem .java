
class Solution{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n){ 
         // your code here 
         int[][] dp = new int[n][W+1];
         for( int x[] : dp ) Arrays.fill(x , -1);
         
        //  return helper( n-1 , val , wt  , W , dp);
        
        // Tabulation :-

            // for( int i=0 ; i <= W ; i++ ){
                
            //     if( i >= wt[0] )  dp[0][i] = val[0];
            //     else dp[0][i] =0;
            // }
            
            // for( int i=1 ; i < n ; i++){
            //     for( int j = 0 ; j <= W ; j++ ){
                    
            //         int notTake = dp[i-1][j];
            //         int take = (int) -1e8;
            //         if( j >= wt[i] ) take = val[i] + dp[i-1][j-wt[i]];
                    
            //         dp[i][j] = Math.max( take , notTake);
            //     }
            // }
            
            // return dp[n-1][W];
            
        // Space Optimized Approach :-
            
            // int[] prev = new int[W+1];
            
            
            // for( int i=0 ; i <= W ; i++ ){
                
            //     if( i >= wt[0] )  prev[i] = val[0];
            //     else prev[i] =0;
            // }
            
            // for( int i=1 ; i < n ; i++){
                
            //     int[] cur = new int[W+1];
            //     for( int j = 0 ; j <= W ; j++ ){
                    
            //         int notTake = prev[j];
            //         int take = (int) -1e8;
            //         if( j >= wt[i] ) take = val[i] + prev[j-wt[i]];
                    
            //         cur[j] = Math.max( take , notTake);
            //     }
            //     prev = cur;
            // }
            
            // return prev[W];
            
        // Further Space Optimization : ( Using 1 Array) :-
            
            int[] prev = new int[W+1];
            
            
            for( int i=0 ; i <= W ; i++ ){
                
                if( i >= wt[0] )  prev[i] = val[0];
                else prev[i] =0;
            }
            
            for( int i=1 ; i < n ; i++){

                for( int j = W ; j >= 0 ; j-- ){
                    
                    int notTake = prev[j];
                    int take = (int) -1e8;
                    if( j >= wt[i] ) take = val[i] + prev[j-wt[i]];
                    
                    prev[j] = Math.max( take , notTake);
                }
            }
            
            return prev[W];
    } 
    
    
    // Memoaization :-
    
        static int helper( int ind , int[] val , int[] wt , int W , int[][] dp){
            
            // Base case :
            if( ind == 0 ){
                if( W >= wt[0] ) return val[0];
                return 0;
            }
            
            if( dp[ind][W] != -1) return dp[ind][W];
            
            int notTake = helper( ind-1 , val , wt , W , dp);
            int take = (int) -1e8;
            if( W >= wt[ind] ) take = val[ind] + helper( ind-1 , val , wt , W-wt[ind] , dp);
            
            return dp[ind][W] = Math.max( take , notTake);
        }
}
