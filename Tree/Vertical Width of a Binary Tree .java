
class Solution {
    // Function to find the vertical width of a Binary Tree.
    int min = Integer.MAX_VALUE;
    int max = 0;
    
    public int verticalWidth(Node root) {
        // code here.
        if( root == null ) return 0;
        int line = 0;
        helper( root , line);
        
        return max - min + 1;
    }
    
    public void helper( Node root , int line){
        
        if( root == null ) return;
        min = Math.min( min , line);
        max = Math.max( max , line);
        
        helper( root.left , line-1);
        helper( root.right , line+1);
    }
}
