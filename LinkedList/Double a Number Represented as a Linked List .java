/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode doubleIt(ListNode head) {
        
        ListNode temp = reverse(head);
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        int carry = 0;
        // int mux = 1;
        while( temp != null ){
            int mux = temp.val * 2;
            mux += carry;
            carry = 0;

            if( mux >= 10 ) {
                carry = mux / 10;
                mux = mux % 10;
            }
            ListNode newNode = new ListNode(mux);
            res.next = newNode;
            res = res.next;

            temp = temp.next;
        }

        if( carry  != 0 ){
            ListNode newNode = new ListNode(carry);
            res.next = newNode;
        }

        return reverse(dummy.next);
    }

    public ListNode reverse( ListNode head ){
        ListNode prev = null;
        while( head != null ){
            ListNode nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }

        return prev;
    }
}
