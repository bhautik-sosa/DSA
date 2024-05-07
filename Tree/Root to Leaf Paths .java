/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper( root , path , ans);
        return ans;
    }
    
    public static void helper( Node root , List<Integer> path , ArrayList<ArrayList<Integer>> ans ){
        
        if( root == null ) return;
        
        path.add(root.data);
        
        if( root.left == null && root.right == null ) {
            
            ans.add( new ArrayList<>(path));
        }
        else {
            
             helper( root.left , path , ans);
             helper( root.right , path , ans);
        }
        
        path.remove( path.size()-1);
    }
}
