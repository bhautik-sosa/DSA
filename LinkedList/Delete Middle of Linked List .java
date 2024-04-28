/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        // if( temp == null || temp.next != null ) return null;
        Node slow = head;
        Node fast = head.next;
        while( fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        if( slow.next != null ) slow.next = slow.next.next;
        
        return head;
    }
    
}
