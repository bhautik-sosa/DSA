class Tuple{
    int stops;
    int node;
    int cost;
    public Tuple( int stops , int node , int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Pair {
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for( int i=0 ; i < n ; i++ ) adj.add( new ArrayList<>());
        
        int m = flights.length;
        
        for( int i=0 ; i < m ; i++){
            adj.get(flights[i][0]).add( new Pair( flights[i][1] , flights[i][2]));
        }
        
        Queue<Tuple> q = new LinkedList<>();
        q.offer( new Tuple( 0 , src , 0));
        
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0;
        
        while( !q.isEmpty()){
            
            Tuple t = q.poll();
            int stop = t.stops;
            int node = t.node;
            int cost = t.cost;
            
            if( stop > k ) continue;
            
            for( Pair it : adj.get(node)){
                int adjNode = it.first;
                int edw = it.second;
                
                if( cost + edw < dist[adjNode] && stop <= k  ){
                    dist[adjNode] = cost + edw;
                    q.offer( new Tuple( stop+1 , adjNode ,dist[adjNode]));
                }
            }
        }
        
        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}
