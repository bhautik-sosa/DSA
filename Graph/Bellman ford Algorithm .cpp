class Solution {
  public:
    /*  Function to implement Bellman Ford
    *   edges: vector of vectors which represents the graph
    *   S: source vertex to start traversing graph with
    *   V: number of vertices
    */
    vector<int> bellman_ford(int V, vector<vector<int>>& edges, int S) {
        // Code here
        vector<int>distance(V, 1e8);
        distance[S] = 0;
        
        for(int count = 1; count<=V-1; count++){
            for(auto &edge:edges){
                int u = edge[0], v = edge[1], wt = edge[2];
                if(distance[u] != 1e8 && distance[u] + wt < distance[v]){
                    distance[v] = distance[u] + wt;
                }
            }
        }
        
        // detect negative cycle
        for(auto &edge:edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            if(distance[u] != 1e8 && distance[u] + wt < distance[v]){
                return {-1};
            }
        }
        return distance;
    }
};
