
/*class Node of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {

    public ArrayList<Integer> Ancestors(Node root, int target) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if( root.data == target ) return ans;
        
        helper( root , target , ans);
        
        return ans;
        
    }
    
     public boolean helper(Node root, int target, ArrayList<Integer> ans) {
        // Base case: if root is null, return false
        if (root == null) {
            return false;
        }
        
        // If current node is the target node, return true
        if (root.data == target) {
            return true;
        }
        
        // Recursively check in left and right subtrees
        if (helper(root.left, target, ans) || helper(root.right, target, ans)) {
            // If target is found in left or right subtree,
            // add current node to ancestors list
            ans.add(root.data);
            return true;
        }
        
        // If target is neither in left nor right subtree,
        // return false and do not add current node to ancestors list
        return false;
    }
}
