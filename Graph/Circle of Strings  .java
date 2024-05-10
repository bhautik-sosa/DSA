
class Solution{
    static int isCircle(int n, String a[]){
        // code here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<Integer>());
        }
        int in[] = new int[26];
        int out[] = new int[26];
        
        for(int i=0;i<n;i++){
            String temp = a[i];
            adj.get(temp.charAt(0)-'a').add(temp.charAt(temp.length()-1)-'a');
            out[temp.charAt(0)-'a']++;
            in[temp.charAt(temp.length()-1)-'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(in[i]!=out[i])return 0;
        }
        boolean vis[] = new boolean[26];
        dfs(adj,a[0].charAt(0)-'a',vis);
        
        for(int i=0;i<26;i++){
            if(vis[i]==false && (in[i]!=0 || out[i]!=0))return 0;
        }
        return 1;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>>adj,int ind,boolean vis[]){
        vis[ind] = true;
        for(int i:adj.get(ind)){
            if(vis[i]==false){
                dfs(adj,i,vis);
            }
        }
    }
}
