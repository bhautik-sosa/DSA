
class Pair{
    int first;
    int second;
    public Pair(int first ,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans =0;
        for( int i=0 ; i < n ; i++){
            for( int j =0 ; j < m ; j++){
                if( vis[i][j] == false && grid[i][j] == '1'){
                    ans++;
                    bfs(i , j, grid , vis);
                }
            }
        }
        return ans;
    }

    public void bfs( int r , int c , char[][] grid , boolean[][] vis){

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        vis[r][c] = true;
        q.offer(new Pair(r, c ));

        int[] deltaRow = {0 , 1 , 0 , -1};
        int[] deltaCol = {-1 , 0 , 1 , 0};
        while( !q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            for( int i=0 ; i < 4 ; i++){
                int neighRow = row + deltaRow[i];
                int neighCol = col + deltaCol[i];
                if( neighRow >=0 && neighRow < n && neighCol >=0 && neighCol  < m 
                    && vis[neighRow][neighCol] == false && grid[neighRow][neighCol] =='1'){
                        q.offer( new Pair(neighRow , neighCol));
                        vis[neighRow][neighCol] = true;
                    }
            }
        }
    }
}
