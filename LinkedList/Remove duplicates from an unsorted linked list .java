/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
*/

class Solution{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head){
         // Your code here
        
        Node cur = head;
        Node prev = null;
        HashSet<Integer> set = new HashSet<>();
        
        while( cur != null ){
            int data = cur.data;
            
            if( set.contains(data)) {
                prev.next = cur.next;
                
            }else {
                set.add(data);
                prev = cur;
            }
            
            cur = cur.next;
        }
        
        return head;
       
    }
}
