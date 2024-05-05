
/*  A Binary Tree nodea
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Tree{
    ArrayList<Integer> noSibling(Node node){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        helper( node , ans);
        
        if( ans.isEmpty() ) {
            ans.add(-1);
            return ans;
        }
        Collections.sort(ans);
        return ans;
    }
    
    public void helper( Node root , ArrayList<Integer> ans ){
        if( root == null ) return;
        if( root.left == null && root.right != null ) ans.add(root.right.data);
        if( root.left != null && root.right == null ) ans.add( root.left.data);
        
        helper( root.left , ans);
        helper( root.right , ans);
    }
}
