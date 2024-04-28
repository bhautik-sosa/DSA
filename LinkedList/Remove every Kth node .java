/* Link list Node
class Node
{
	Node next;
	int data;
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
class Solution{
    /*You are required to complete this method*/
    Node delete(Node head, int k){
	// Your code here	 
	    if( k == 1 ) return null;
	    Node temp = head;
	    int cnt = 1;
	    while( temp != null ){
	        
	        if( cnt == k-1 ){
	            if( temp.next != null) temp.next = temp.next.next;
	            cnt = 0;
	        }
	        else {
	            temp = temp.next;
	            cnt++;
	        }
	        
	    }
	    return head;
    }
}
