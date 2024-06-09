
class Solution {
    
    static int mod = 1000000007;
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        int[][] dp = new int[n][m];
        for( int i=0 ; i < n ; i++ ) Arrays.fill(dp[i] , -1);
        
        // return helper( n-1 , m-1 , grid , dp) % mod;
        
        // Tabulation :- 
            
            dp[0][0] = 1 ;
            
            for( int i=0 ; i < n ; i++ ){
                for( int j =0 ; j < m ; j++ ){
                    
                    if( grid[i][j] == 0 ) {
                        dp[i][j] = 0;
                        continue;
                    }
                    
                    if( i == 0 && j == 0 ) continue;
                    else {
                        
                        int up = 0 , left = 0;
                        
                        if(i > 0) up = dp[i-1][j] % mod;
                        if(j > 0) left = dp[i][j-1] % mod;
                        
                        dp[i][j] = (up % mod + left % mod) % mod;
                    }
                }
            }
            
            return dp[n-1][m-1] % mod;
            
    }
    
    // Memorization :- 
    
        static int helper( int row , int col , int[][] grid , int[][] dp ) {
            
            if( row == 0 && col == 0 && grid[0][0] == 1) return 1;
            if( row < 0 || col < 0 ) return 0;
            
            if( grid[row][col] != 1 ) return 0;
            
            if( dp[row][col] != -1 ) return dp[row][col] % mod;
            
            int up = helper( row -1 , col , grid , dp) % mod;
            int left = helper( row , col - 1 , grid , dp) % mod;
            
            return dp[row][col] =  (up % mod + left % mod ) % mod;
        }
}
