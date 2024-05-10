/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution{
    //Function to sort the given linked list using Merge Sort.
    
    static Node mergeSort(Node head){
        // add your code here
        if(head==null || head.next==null) return head;
        Node middle,leftHead,rightHead;
        
        middle=findMiddle(head);
        
        leftHead=head;
        rightHead=middle.next;
        middle.next=null;
        
        leftHead= mergeSort(leftHead);
        rightHead=mergeSort(rightHead);
        
        return merge2(leftHead,rightHead);
    }
    
    public static Node findMiddle(Node head){
        
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public static Node merge2(Node l1,Node l2){
        Node dummy=new Node(-1);
        Node temp=dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.data<l2.data)
            {
                temp.next=l1;
                temp=l1;
                l1=l1.next;
            }
            else 
            {
                temp.next=l2;
                temp=l2;
                l2=l2.next;
            }
        }
        if(l1!=null) temp.next=l1;
        else temp.next=l2;
        return dummy.next;
    }
}
