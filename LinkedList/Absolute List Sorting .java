
/* The structure of the node of the Linked List is
class Node
{
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
 }
*/

class Solution{
	Node sortList(Node head) {
		// Your code here
		Node curr = head;
		Node prev = null;
		if(curr == null) return head;
		while(curr != null){
		    
		    if(curr.data < 0 && curr!=head){
		       prev.next = curr.next;
		        curr.next = head;
		        head = curr;
		        curr = prev.next;
		        
		    }else{
		        prev = curr;
		        curr = curr.next;
		    }
		    
		}
		
		return head;
	}
}
