/* 
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

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node root){
        // code here
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.offer(root);
        ArrayList<Integer> temp = new ArrayList<>();
        while( !q.isEmpty()){
            int size = q.size();
            for( int i=0 ; i < size ; i++){
                Node node = q.poll();
                temp.add(node.data);
                
                if( node.left != null ) q.offer( node.left);
                if( node.right != null ) q.offer( node.right);
            }
           
            ans.addAll(0 , temp);
            temp.clear();
        }
        
        return ans;
    }
}
