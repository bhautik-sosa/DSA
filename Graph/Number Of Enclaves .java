class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        int[] deltaRow = { 0 , -1 , 0 , 1};
        int[] deltaCol = { -1 , 0 , 1 , 0};
        
        for( int i= 0 ; i < m ; i++ ){
            if( grid[0][i] == 1 && vis[0][i] == false ) {
                dfs(0 , i , grid , vis , deltaRow , deltaCol);
            }
            
            if( grid[n-1][i] == 1 && vis[n-1][i] == false ) {
                dfs(n-1 , i , grid , vis , deltaRow , deltaCol);
            }
        }
        
        for( int i= 0 ; i < n ; i++ ){
            if( grid[i][0] == 1 && vis[i][0] == false ) {
                dfs(i , 0 , grid , vis , deltaRow , deltaCol);
            }
            
            if( grid[i][m-1] == 1 && vis[i][m-1] == false ) {
                dfs(i , m-1 , grid , vis , deltaRow , deltaCol);
            }
        }
        
        int ans = 0;
        for( int i=0 ; i < n ; i++ ){
            for( int j=0 ; j < m ; j++){
                if( vis[i][j] == false && grid[i][j] == 1 ) ans++;
            }
        }
        
        return ans;
    }
    
    public void dfs( int r , int c , int[][] grid , boolean[][] vis , int[] deltaRow , int[] deltaCol){
        int n = grid.length;
        int m = grid[0].length;
        
        vis[r][c] = true;
        for( int i=0 ; i < 4 ; i++ ){
            int nRow = r + deltaRow[i];
            int nCol = c + deltaCol[i];
            
            if( nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&  
                grid[nRow][nCol] == 1 && vis[nRow][nCol] == false ) {
                    dfs( nRow , nCol , grid , vis , deltaRow , deltaCol );
                }
        }
    }
}
