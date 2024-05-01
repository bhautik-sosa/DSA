/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        helper( root , ans );
        return ans;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        // code here
        if( A.size() == 0 ) return null;
        
        return buildTree(A,0 , A.size()-1);
    }
    
    
    public void helper( Node root , ArrayList<Integer> ans ){
        if( root == null ) return;
        helper( root.left , ans );
        ans.add(root.data);
        helper(root.right , ans);
    }
    
    private Node buildTree( ArrayList<Integer> inorder, int start, int end) {
        
        if (start > end) {
            return null;
        }
        // Find the index of the middle element
        int mid = start + (end - start) / 2;
        
        // Create the root node
        Node root = new Node(inorder.get(mid));
        
        // Recursively build left and right subtrees
        root.left = buildTree(inorder, start, mid - 1);
        root.right = buildTree(inorder, mid + 1, end);
        
        return root;
    }
};
