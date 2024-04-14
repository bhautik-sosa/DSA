class Solution
{ 
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        
        // -----> Kahn's Algorithm for Topological Sort :
        
        int[] inDegree = new int[V];
        Arrays.fill( inDegree , 0);
        
        for( int i=0 ; i < V ; i++){
            
            for( int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for( int i=0 ; i < V ; i++){
            if( inDegree[i] == 0 ){
                q.offer(i);
            }
        }
        
        int[] topo = new int[V];
        int ind =0;
        while( !q.isEmpty()){
            int node = q.poll();
            
            topo[ind++] = node;
            for( int it : adj.get(node)){
                inDegree[it]--;
                if( inDegree[it] == 0 ) q.offer(it);
            }
        }
        
        return topo;
    }

}
