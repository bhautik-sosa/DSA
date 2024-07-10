
class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        // code here

        // int max = 0;
        int[][] dp = new int[n][m];
        // for( int i=0 ; i < n ; i++ ) Arrays.fill(dp[i] , -1);
        
        // for( int i = n-1 ; i >= 0 ; i--){
            
        //     for( int j = m-1 ; j >= 0 ; j--){
                
        //         if( mat[i][j] == 1 ) {
        //             max = Math.max( max , helper( i , j , mat , dp) );
        //         }
        //     }
        // }
        
        // return max;
        
        
        // Tabulation :-
        
            int max = 0;
        
            for( int i=0 ; i < m ; i++) {
                dp[0][i] = mat[0][i];
                max = Math.max( max , dp[0][i]);
            }
            
            for( int i=0 ; i < n ; i++) {
                dp[i][0] = mat[i][0];
                max = Math.max( max , dp[i][0]);
            }
        
            for( int i=1 ; i < n ; i++) {
                for( int j =1 ; j < m ; j++ ){
                    
                    int temp = mat[i][j];
                    if( temp == 0 ) dp[i][j] = 0;
                    else dp[i][j] = temp + Math.min( dp[i-1][j-1] , 
                                            Math.min( dp[i][j-1] , dp[i-1][j]) );
                                            
                    max = Math.max( max , dp[i][j]);
                }
            }
            
            return max;
        
    }
    
    // Memoaization :-
    static int helper( int row , int col , int[][] mat , int[][] dp){
        
            
            // Base cases :-
            if( row < 0 || col < 0 ) return 0;
            if( mat[row][col] == 0 ) return 0;
            
            
            if( dp[row][col] != -1 ) return dp[row][col];
            
            int ans = 0;
            if( mat[row][col] == 1 ) ans++;
            
            return dp[row][col] = ans + Math.min( helper( row-1 , col , mat , dp) , 
                            Math.min( helper(row-1 , col-1 , mat , dp) , helper(row , col-1 , mat , dp)));
            
    }
}
