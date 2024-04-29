
class Pair {
    int first;
    int second;
    int third;
    public Pair( int first , int second, int third ){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if( A[0][0] == 0) return -1;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer( new Pair( 0 , 0, 0));
        boolean[][] vis = new boolean[N][M];
        vis[0][0] = true;
        
        int[] deltaRow = { 0 , -1 , 0 , 1};
        int[] deltaCol = { -1 , 0 , 1 , 0};
        
        int ans = Integer.MAX_VALUE;
        
        while( !q.isEmpty()){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            int dist = p.third;
            
            if( r == X && c == Y ) {
                ans = Math.min( ans , dist );
            }
            
            for( int i=0 ; i < 4 ; i++){
                int nRow = deltaRow[i] + r;
                int nCol = deltaCol[i] + c;
                
                if( nRow >= 0 && nRow < N && nCol >= 0 && nCol < M && A[nRow][nCol] == 1 && vis[nRow][nCol] == false ){
                    vis[nRow][nCol] = true;
                    q.offer( new Pair(nRow , nCol , dist + 1));
                }
            }
        }
        return ans== Integer.MAX_VALUE ? -1 : ans;
    }
};
