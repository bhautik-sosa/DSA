/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        helper( root , 0 , map );
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for( Map.Entry<Integer , Integer> en : map.entrySet()){
            ans.add( en.getValue());
        }
        
        return ans;
        
    }
    
    public void helper(Node root , int line , TreeMap<Integer , Integer> map ){
        if( root == null ) return;
        
        if( map.containsKey(line) ){
            map.put( line , map.get(line) + root.data );
        }
        else map.put( line , root.data);
        
        helper( root.left , line-1 , map);
        helper( root.right , line+1 , map);
    }
}
