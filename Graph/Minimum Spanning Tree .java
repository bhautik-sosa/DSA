class Pair {
    int first;
    int second;;
    public Pair( int first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution{
    
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for( int i=0 ; i < V ; i++ ) adj.add( new ArrayList<>());
	    
	    for( int i=0 ; i < E ; i++ ){
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        if (u >= 0 && u < V && v >= 0 && v < V) { // Add boundary check
                adj.get(u).add(new Pair(v, wt));
                adj.get(v).add(new Pair(u, wt));
            }
	    }
	    
	    boolean[] vis = new boolean[V];
	    
	    PriorityQueue<Pair> pq = new PriorityQueue<>( (x, y) -> x.first - y.first);

	    int sum = 0;
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            
            Pair p = pq.poll();
            int wt = p.first;
            int node = p.second;
            
            if (vis[node]) continue;
            vis[node] = true;
            sum += wt;
            for (Pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;
                if (!vis[adjNode]) {
                    pq.offer(new Pair(edW, adjNode));
                }
            }
        }
	    
	    return sum;
	}
}
