class Pair{
    int first;
    int second;
    int third;
    
    public Pair( int dist , int row ,  int col){
        first = dist;
        second = row;
        third = col;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if( source[0]== destination[0] && source[1] == destination[1] ) return 0;
        int n = grid.length;
        int m = grid[0].length;
        
        int ans = Integer.MAX_VALUE;
        
        int[] deltaRow = {0 , -1 , 0 , 1};
        int[] deltaCol = {-1 , 0 , 1 , 0};
        
        int[][] dist = new int[n][m];
        for( int i=0 ; i < n ; i++){
            Arrays.fill(dist[i] , Integer.MAX_VALUE);
        }
        
        dist[source[0]][source[1]] = 0;
        
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.offer( new Pair(0 , source[0] , source[1]));
        
        
        while( !q.isEmpty()){
            
            int d = q.peek().first;
            int r = q.peek().second;
            int c = q.peek().third;
            q.poll();
            
            for( int i=0 ; i < 4 ; i++ ){
                
                int nRow = r + deltaRow[i];
                int nCol = c + deltaCol[i];
                
                if( nRow >= 0 && nRow < n && nCol >=0 && nCol < m &&
                    grid[nRow][nCol] == 1 && vis[nRow][nCol] == false){
                        
                        dist[nRow][nCol] = d + 1;
                        if( nRow == destination[0] && nCol == destination[1] ) return d+1;
                        vis[nRow][nCol] = true;
                        q.offer( new Pair( 1 + d , nRow , nCol));
                    }
            }
        }
        
        return -1;
        
        
        // --->   Both of these are Right Code    <-----
        
        
        
        
        // int n = grid.length;
        // int m = grid[0].length;
        
        // int ans = Integer.MAX_VALUE;
        
        // int[] deltaRow = {0 , -1 , 0 , 1};
        // int[] deltaCol = {-1 , 0 , 1 , 0};
        
        // boolean[][] vis = new boolean[n][m];
        // Queue<Pair> q = new LinkedList<>();
        // q.offer( new Pair(0 , source[0] , source[1]));
        
        // while( !q.isEmpty()){
            
        //     Pair p = q.poll();
        //     int d = p.first;
        //     int r = p.second;
        //     int c = p.third;
            
        //     if( r == destination[0] && c == destination[1] ) {
        //         ans = Math.min( ans , d);
        //         continue;
        //     }
            
        //     for( int i=0 ; i < 4 ; i++){
        //         int nRow = r + deltaRow[i];
        //         int nCol = c + deltaCol[i];
                
        //         if( nRow >= 0 && nRow < n && nCol >=0 && nCol < m &&
        //             vis[nRow][nCol] == false && grid[nRow][nCol] == 1 ){
                        
                        
        //                 vis[nRow][nCol] = true;
        //                 q.offer( new Pair( d+1 , nRow , nCol));
        //             }
        //     }
        // }
        // return  ans != Integer.MAX_VALUE ? ans :-1 ;
    }
}
