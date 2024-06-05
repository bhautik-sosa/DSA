
/* A Binary Tree node
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
class Pair{
    int first;
    boolean second;
    
    public Pair( int first , boolean second ){
        this.first = first;
        this.second = second;
    }
}

class Solution{
	boolean isSumTree(Node root){
        // Your code here
        return helper(root , 0).second;
	}
	
	public Pair helper( Node root , int sum ){
	    
	    if( root == null ) return new Pair( 0 , true);
	    if( root.left == null && root.right == null ) return new Pair( root.data , true);
	    
	    Pair left = helper( root.left, sum );
	    Pair right = helper( root.right, sum);
	    
	    int total = left.first + right.first + root.data;
	    
	    boolean flag = true;
	    if( left.first + right.first != root.data ) flag = false;
	    if( !left.second || !right.second ) flag = false;
	    
	    return new Pair( total , flag);
	    
	}
}
