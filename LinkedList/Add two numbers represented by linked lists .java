/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        
        Node temp1 = reverse(num1); 
        Node temp2 = reverse(num2);
        
        
        
        int carry = 0;
        while( temp1 != null || temp2 != null ){
            
            int sum = carry;
            
            if( temp1 != null && temp2 != null ){
                sum += temp1.data + temp2.data ;
            }
            else if( temp1 == null ){
                sum += temp2.data;
            }
            else {
                sum += temp1.data;
            }
            
            if( sum >= 10 ){
                carry = 1;
                sum = sum % 10;
            }else {
                carry = 0;
            }
            
            Node newNode = new Node(sum);
            res.next = newNode;
            res = res.next;
            
            if(temp1 != null ) temp1 = temp1.next;
            if(temp2 != null ) temp2 = temp2.next;
        }
        
        if( carry == 1){
            res.next  = new Node(carry);
            res = res.next;
        }
        
        res.next = null;
        
        Node ans = reverse( dummyNode.next);
        
        while( ans != null && ans.data == 0 ){
            ans = ans.next;
        }
        
        return ans == null ? new Node(0) : ans;
        
    }
    
    static Node reverse( Node head ){
        
        Node prev = null;
        while( head != null ){
            Node nxt = head.next;
            head.next = prev;
            prev = head;
            
            head = nxt;
        }
        
        return prev;
    }
}
