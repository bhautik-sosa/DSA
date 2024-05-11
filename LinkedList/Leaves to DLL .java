/*
Node is as follows:
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Tree{
    // return the head of the DLL and remove those node from the tree as well.
    Node head = new Node(-1);
    Node prev = null;
    boolean isHead = true;
    public Node convertToDLL(Node root){
        // Code here
        if( root == null || root.right == null ) return root;
        Node temp = root;
        getLeaves(temp);
        removeLeaves(root);
        return head;
    }
    
    public void getLeaves( Node root ){
        if( root == null ) return;
        
        if( isLeaf(root) ){
            
            if( isHead ) {
                head.data = root.data;
                head.left = prev;
                head.right = null;
                isHead = false;
                prev = head;
            }
            else {
                Node newNode = new Node(root.data);
                newNode.left = prev;
                if(prev != null )  prev.right = newNode;
                newNode.right = null;
                prev = newNode;
            }
            return;
        }
        getLeaves(root.left );
        getLeaves( root.right);
    }
    
    public void removeLeaves( Node root ){
        if( root == null ) return;
        if( isLeaf(root.left) ) {
            root.left = null;
        }
        if( isLeaf(root.right)) {
            root.right = null;
        }
        
        removeLeaves( root.left);
        removeLeaves( root.right);
    }
    
    public boolean isLeaf( Node root ){
        if( root == null ) return false;
        if( root.left == null && root.right == null) return true;
        return false;
    }
}
