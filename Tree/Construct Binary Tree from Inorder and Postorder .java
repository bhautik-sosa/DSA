/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        
        if (in.length != post.length || n <= 0)
            return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(in[i], i);
        }

        return helper(in, 0, n - 1, post, 0, n - 1, map);
    }
    
    Node helper( int[] inorder, int inSt, int inEnd, int[] postorder, int postSt, int postEnd,
            HashMap<Integer, Integer> map) {
        if (inSt > inEnd || postSt > postEnd)
            return null;

        Node root = new Node(postorder[postEnd]);
        int inRoot = map.get(root.data);
        int numLeft = inRoot - inSt;

        root.left = helper(inorder, inSt, inRoot - 1, postorder, postSt, postSt + numLeft - 1, map);
        root.right = helper(inorder, inRoot + 1, inEnd, postorder, postSt + numLeft, postEnd - 1, map);

        return root;
    }
}
