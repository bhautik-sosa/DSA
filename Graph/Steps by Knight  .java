class Pair {
    int first;
    int second;
    int third;
    public Pair( int first , int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N){
        // Code here
        boolean[][] vis = new boolean[N+1][N+1];
        
        Queue<Pair> q = new LinkedList<>();
        q.offer( new Pair( KnightPos[0] , KnightPos[1] , 0));
        vis[KnightPos[0]][KnightPos[1]] = true;
        
        int[] deltaRow = { -1 , -2 , -2, -1, 1, 2, 2 , 1 };
        int[] deltaCol = { -2 , -1 , 1 , 2 , 2, 1, -1, -2};
        int ans = Integer.MAX_VALUE;
        while( !q.isEmpty()){
            
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            int step = p.third;
            
            if( r == TargetPos[0] && c == TargetPos[1] ) {
                ans = Math.min( step , ans);
            }
            for( int i=0 ; i < 8 ; i++ ){
                int nRow = r + deltaRow[i];
                int nCol = c + deltaCol[i];
                
                if( nRow > 0 && nRow <= N && nCol > 0 && nCol <= N && vis[nRow][nCol] == false){
                    
                    vis[nRow][nCol] = true;
                    q.offer( new Pair( nRow , nCol , step+1));
                }
            }
        }
        return ans;
    }
}
