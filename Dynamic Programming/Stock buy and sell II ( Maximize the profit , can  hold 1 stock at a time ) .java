

class Solution {
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        // int[][] dp = new int[n][2];
        // for( int i=0 ; i < n ; i++ ) Arrays.fill( dp[i] , -1);
        // return helper( 0 , 1 , prices , dp);
        
    // Tabulation :-
            // int[][] dp = new int[n+1][2];
            // dp[n][0] = dp[n][1] = 0;
            
            // for( int ind = n-1 ; ind >= 0 ; ind-- ){
                
            //     for( int canBuy =0 ; canBuy <= 1 ; canBuy++ ){
                    
            //         if( canBuy == 1 ){
                
            //             int buy = -prices[ind] + dp[ind+1][0];
            //             int notBuy =  0 + dp[ind+1][1];
                        
            //             int profit = Math.max( buy , notBuy);
                        
            //             dp[ind][canBuy] = profit;
            //         }
            //         else {
                        
            //             int sell = prices[ind] + dp[ind + 1][1];
            //             int noTSell = 0 + dp[ind + 1][0];
            //             int profit = Math.max( sell , noTSell);
                        
            //             dp[ind][canBuy] =  profit;
            //         }
            //     }
            // }
            
            // return dp[0][1];
            
        
        // Space Optimized :-\
        
            int[] ahead = new int[2];
            
             for( int ind = n-1 ; ind >= 0 ; ind-- ){
                
                int[] cur = new int[2];
                
                for( int canBuy =0 ; canBuy <= 1 ; canBuy++ ){
                    
                    if( canBuy == 1 ){
                
                        int buy = -prices[ind] +ahead[0];
                        int notBuy =  0 + ahead[1];
                        
                        int profit = Math.max( buy , notBuy);
                        
                        cur[canBuy] = profit;
                    }
                    else {
                        
                        int sell = prices[ind] + ahead[1];
                        int noTSell = 0 + ahead[0];
                        int profit = Math.max( sell , noTSell);
                        
                        cur[canBuy] =  profit;
                    }
                }
                ahead = cur;
            }
            
            return ahead[1];
        
    }
    
    
    // Memoization :-
    
    public static int helper( int ind , int canBuy , int[] prices , int[][] dp ){
        
        // Base case :-
        
        if( ind == prices.length ) return 0;
        
        if( dp[ind][canBuy] != -1 ) return dp[ind][canBuy];
        
        if( canBuy == 1 ){
            
            int buy = - prices[ind] + helper( ind+1 , 0 , prices , dp);
            int notBuy =  0 + helper(ind+1 ,  1  ,  prices , dp);
            
            int profit = Math.max( buy , notBuy);
            
            return dp[ind][canBuy] = profit;
        }
        else {
            
            int sell = prices[ind] + helper( ind + 1 , 1 , prices , dp);
            int noTSell = 0 + helper( ind + 1 , 0 , prices , dp);
            int profit = Math.max( sell , noTSell);
            
            return dp[ind][canBuy] =  profit;
        }
    }
}
