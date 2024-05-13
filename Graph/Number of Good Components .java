
class Solution {
    
    
    public static int findNumberOfGoodComponent(int e, int v, int[][] edg) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for( int i=0 ; i <= v ; i++ ) adj.add(new ArrayList<>());
        for( int i=0 ; i < e ; i++ ){
            int n1 = edg[i][0];
            int n2 = edg[i][1];
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }
        
        boolean vis[] = new boolean[v+1];
        int ans = 0;
        Arrays.fill(vis , false);
        
        for( int i=1 ; i <= v ; i++){
            if( bfs( i , adj , vis)) ans++;
        }
        return ans;
    }
    
    public static boolean bfs( int start , ArrayList<ArrayList<Integer>> adj , boolean[] vis){
        int num = 0 , edges = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        vis[start] = true;
        while( !q.isEmpty()){
            int node = q.poll();
            
            num++;
            edges += adj.get(node).size();
            
            for( int it : adj.get(node)){
                if( !vis[it]) {
                     q.offer( it);
                     vis[it] = true;
                }
            }
        }
        
        return (num * (num-1) == edges);
    }
 
}
