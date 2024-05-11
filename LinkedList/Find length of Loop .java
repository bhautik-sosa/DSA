/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

class Solution{
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head){
        //Add your code here.
        if(head == null ){
            return 0 ; 
        }
        Node slow = head; 
        Node fast  = head; 
        boolean isCycle = false  ; 

        while( fast!= null && fast.next != null ) { 
            slow =slow.next; 
            fast = fast.next.next ; 
            if(slow == fast ) {
                isCycle =true; 
                break ;
            }
        }
        
        if(isCycle == false) return 0; 
        
        fast = fast.next;
        int dist = 1;
        
        while( fast != slow) {
            fast = fast.next; 
            dist++;
        }
        return dist; 
        
    }
}
