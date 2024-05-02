
/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree{
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        helper( root , 0 , k , ans);
        return ans;
    }
    
    public void helper( Node root , int cur , int k , ArrayList<Integer> ans){
        
        if( root == null ) return;
        if( cur == k ) {
            ans.add( root.data);
            return;
        }
        helper( root.left , cur + 1 , k , ans );
        helper( root.right , cur + 1 , k , ans );
    }
}
