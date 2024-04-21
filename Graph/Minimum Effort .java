
class Pair{
    
    int distance;
    int row;
    int col;
    public Pair(int dist , int row , int col){
        this.distance = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    int MinimumEffort(int heights[][]) {
        
        int n = heights.length;
        int m = heights[0].length;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>( (x, y) -> x.distance - y.distance);
        
        int[][] dist = new int[n][m];
        for( int i=0 ; i < n ; i++ ) Arrays.fill(dist[i] , Integer.MAX_VALUE);
        dist[0][0] = 0;
        pq.offer( new Pair( 0 , 0 , 0));
        
        
        int[] deltaRow = { -1 , 0 , 1 , 0 };
        int[] deltaCol = { 0  ,-1 , 0 , 1 };
        while( !pq.isEmpty()){
            
            Pair p = pq.poll();
            int diff = p.distance;
            int r = p.row;
            int c = p.col;
            if( r== n-1 && c == m-1 ) return diff;
            for( int i=0 ; i < 4 ; i++){
                int nRow = r + deltaRow[i];
                int nCol = c + deltaCol[i];
                
                if( nRow >=0 && nRow < n && nCol >=0 && nCol < m){
                    
                    int newEffort = Math.max( diff , Math.abs(heights[r][c] - heights[nRow][nCol]));
                    
                    if( newEffort < dist[nRow][nCol]){
                        
                        pq.offer( new Pair( newEffort , nRow , nCol));
                        dist[nRow][nCol] = newEffort;
                    }
                }
            }
        }
        return 0;
    }
}
