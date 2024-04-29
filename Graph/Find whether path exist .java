class Pair{
    int first;
    int second;
    public Pair( int first , int second ){
        this.first = first;
        this.second = second;
    }
}

class Solution{
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid){
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        
        int sr = -1 , sc = -1;
        
        for( int i=0 ; i < n ; i++ ){
            for( int j=0 ; j < m ; j++ ){
                if( grid[i][j] == 1 ){
                    sr = i;
                    sc = j;
                    break;
                }
            }
        }
        if( sr == -1 || sc == -1 ) return false;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer( new Pair( sr , sc));
        vis[sr][sc] = true;
        
        int[] deltaRow = { 0 , -1 , 0 , 1 };
        int[] deltaCol = { -1 , 0 , 1 , 0 };
        
        while( !q.isEmpty()){
            
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            
            if( grid[r][c] == 2 ) return true;
            
            for( int i=0 ; i < 4 ; i++){
                
                int nRow = deltaRow[i] + r;
                int nCol = deltaCol[i] + c;
                
                if( nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    (grid[nRow][nCol] == 3 || grid[nRow][nCol] == 2) &&  vis[nRow][nCol] == false){
                        
                        vis[nRow][nCol] = true;
                        q.offer( new Pair( nRow , nCol));
                    }
            }
        }
         
        return false;
    }
}
