
class Solution{
    public int solve(int n, int m, int grid[][]){
        // Code here
        
        int[][][] dp = new int[n][m][m];
        for( int i=0 ; i < n ; i++ ){
            for( int j=0 ; j < m ; j++ ){
                for( int k = 0 ; k < m ; k++ ){
                    dp[i][j][k] = -1;
                }
            }
        }
        
        
        // return helper( 0 , 0 , m-1 , grid , dp);
        
        // Tabulation :- 
            for( int i= m-1 ; i >= 0 ; i--){
                for( int j = m-1 ; j >= 0 ; j--){
                    
                    if( i == j ) dp[n-1][i][j] = grid[n-1][i];
                    else dp[n-1][i][j] = grid[n-1][i] + grid[n-1][j];
                }
            }
            
            int[] delta = { -1 , 0 , 1 };
            for( int i = n-2 ; i >= 0 ; i-- ){
                for( int j = m-1 ; j >= 0 ; j--){
                    
                    for( int k = m-1 ; k >= 0 ; k-- ){
                        
                        int max = 0;
                        
                        for( int dj1 = -1 ; dj1< 2 ; dj1++){
                            for( int dj2 = -1 ; dj2 < 2 ; dj2++){
                                
                                int value =0;
                                if( j == k ) value = grid[i][j];
                                else value = grid[i][j] + grid[i][k];
                                
                                if( j + dj1 >= 0 && j + dj1 < m && k + dj2 >= 0 && k + dj2 < m ) 
                                    value +=  dp[i+1][j+dj1][k + dj2];
                                else
                                    value +=  (int) -1e8;
                                    
                                max = Math.max( max , value);
                            }
                        }
                        
                        dp[i][j][k]= max;
                    }
                }
            }
            
            return dp[0][0][m-1];
    }
    
    
    // Memoization :-
    
        public int helper( int row , int col1 , int col2 , int[][] grid , int[][][] dp){
            
            if( col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length ) return (int)-1e8;
            
            if( row == grid.length -1) {
                
                if( col1 == col2 ) return grid[row][col1];
                return grid[row][col1] + grid[row][col2];
            }
            
            if( dp[row][col1][col2] != -1 ) return dp[row][col1][col2];
            
            int[] deltaCol = { -1 , 0 , 1 };
            int max = 0;
            
            for( int i=0 ; i < 3 ; i++ ){
                for( int j=0 ; j < 3 ; j++ ){
                    
                    if (col1 == col2)
                        max = Math.max(max, grid[row][col1] + helper(row + 1, col1 + deltaCol[i], col2 + deltaCol[j], grid , dp));
                    else
                        max = Math.max(max, grid[row][col1] + grid[row][col2] + helper(row + 1, col1 + deltaCol[i], col2 + deltaCol[j], grid , dp));
                }
            }
            
            return  dp[row][col1][col2] = max;
        }
}
