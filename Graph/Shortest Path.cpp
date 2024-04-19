class Solution {
  public:
    vector<int> shortestPath(int n, int m, vector<vector<int>>& edges) {
        // Code here
        // Dijkstra algo + Memoization Bactrack
         vector<pair<int,int>>adj[n+1];
         for(auto it:edges)
         {
             adj[it[0]].push_back({it[1],it[2]});
             adj[it[1]].push_back({it[0],it[2]});
         }
         
         queue<pair<int,int>> pairQueue;
         
         vector<int> distance(n+1,1e9);
         distance[1]=0;
    
         vector<int> parentNode(n+1);
    
        for(int i=1;i<=n;i++)
        {
            parentNode[i]=i;
        }
         
         pairQueue.push({0,1});
         
         while(!pairQueue.empty()){
             auto it = pairQueue.front();
             int node = it.second;
             int dis = it.first;
             pairQueue.pop();
             
             for(auto it:adj[node]){
                 int adjNode = it.first;
                 int edgeWeight = it.second;
                 
                 if(dis+edgeWeight<distance[adjNode]){
                     distance[adjNode] = dis+edgeWeight;
                     parentNode[adjNode] = node;
                     pairQueue.push({distance[adjNode],adjNode});
                 }
             }
         }
         if(distance[n] ==1e9)
           return {-1};
       
        vector<int> path;
     
        int end  =n;
        while(parentNode[end]!=end){
        path.push_back(end);
        end = parentNode[end];
        }
     
        path.push_back(1);
     
        path.push_back(distance[n]);
            reverse(path.begin(),path.end());
            
            return path;
    }

};
