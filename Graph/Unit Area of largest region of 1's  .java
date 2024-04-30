class Pair{
    int first;
    int second;
    public Pair( int first , int second ){
        this.first = first;
        this.second = second;
    }
}

class Solution{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid){
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        
        int[] deltaRow = { 0 , -1 , 0 , 1 , -1 ,-1 , 1, 1 };
        int[] deltaCol = { -1 , 0 , 1 , 0 , -1 , 1 , 1, -1 };
        int maxCnt = Integer.MIN_VALUE;
        
        for( int i=0 ; i < n ; i++ ){
            for( int j =0 ; j < m ; j++ ){
                // int cnt = 0;
                if( grid[i][j] == 1 && vis[i][j] == false){
                    vis[i][j] = true;
                    maxCnt = Math.max( maxCnt , bfs( i , j , grid , vis , deltaRow , deltaCol) );
                }
            }
        }
        return maxCnt == Integer.MIN_VALUE ? 0 : maxCnt;
    }
    
    public int bfs( int r , int c , int[][] grid , boolean[][] vis , int[] deltaRow , int[] deltaCol  ){
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.offer( new Pair( r , c ));
        int cnt = 1;
        while( !q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            
            for( int i=0 ; i < 8 ; i++ ){
                int nRow = row + deltaRow[i];
                int nCol = col + deltaCol[i];
                
                if( nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && 
                    grid[nRow][nCol] == 1 && vis[nRow][nCol] == false) {
                        
                        vis[nRow][nCol] = true;
                        q.offer( new Pair(nRow , nCol));
                        cnt++;
                    }
            }
        }
        
        return cnt;
    }
}
