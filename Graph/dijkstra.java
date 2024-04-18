class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        // Write your code here
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>( (x, y ) -> x.second - y.second);
        pq.offer(new Pair(S , 0));
        
        int[] dist = new int[V];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[S] = 0;
        
        while( !pq.isEmpty()){
            int node = pq.peek().first;
            int d = pq.peek().second;
            pq.poll();
            
            for( int i =0 ; i < adj.get(node).size() ; i++){
                
                int edgeW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                
                if( edgeW + d < dist[adjNode]){
                    dist[adjNode] = edgeW + d;
                    pq.offer(new Pair( adjNode , dist[adjNode]));
                }
            }
        }
        return dist;
    }
}
