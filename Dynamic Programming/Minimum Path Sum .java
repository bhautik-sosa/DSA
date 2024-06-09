
class Solution {
    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for( int i=0 ; i < n ; i++ ) Arrays.fill(dp[i], -1);

        // return helper(n-1 , m-1 , grid , dp);

        // Tabulation :-
            // dp[0][0] = grid[0][0];
            // for( int i=0 ; i < n ; i++ ){
                
            //     for( int j =0 ; j < m ; j++ ){
            //         int up = (int)1e9;
            //         int left = (int)1e9;

            //         if( i == 0 && j == 0 ) continue;

            //         if( i > 0 ) up = grid[i][j] + dp[i-1][j];
            //         if( j > 0 ) left = grid[i][j] + dp[i][j-1];

            //         dp[i][j] = Math.min( left , up);
            //     }
            // }
            // return dp[n-1][m-1];

        // Space Optimized :-

            int prev[] = new int[m];
            Arrays.fill(prev , 0);

            for( int i=0 ; i < n ; i++ ){

                int[] cur = new int[m];
                Arrays.fill(cur , 0);
                for( int j =0 ; j < m ; j++ ){

                    if( i == 0 && j == 0 ) {
                        cur[j] = grid[i][j];
                    }
                    else {

                        int up = (int) 1e9;
                        int left = (int) 1e9;
                        if(i > 0) up = grid[i][j] + prev[j];
                        if( j > 0 ) left = grid[i][j] + cur[j-1]; 
                        
                        cur[j] = Math.min(left , up);
                    }

                }

                prev = cur;
            }

            return prev[m-1];
    }

    // Memorization :-

        public int helper( int row, int col , int[][] grid , int[][] dp){

            if( row == 0 && col == 0 ) return grid[row][col];

            if( row < 0 || col < 0 ) return (int)1e9;

            if( dp[row][col] != -1 ) return dp[row][col];

            int up = grid[row][col]  + helper( row -1 , col , grid , dp);
            int left = grid[row][col] + helper( row , col-1 , grid , dp);
            
            return dp[row][col] = Math.min(up , left);
        }
}
