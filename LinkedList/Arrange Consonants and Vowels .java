/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node temp = head;
        Node vowels = new Node('A');
        Node r1 = vowels;
        Node consonants = new Node('A');
        Node r2 = consonants;
        
        while( temp != null ){
            
            if( temp.data == 'a' || temp.data == 'e' || temp.data == 'i' || temp.data == 'o' || temp.data == 'u'){
                r1.next = temp;
                r1 = r1.next;
            }
            else {
                r2.next = temp;
                r2 = r2.next;
            }
            
            temp = temp.next;
        }
        r2.next = null;
        if( vowels != null ) r1.next = consonants.next;
        else return consonants.next;
        
        return vowels.next;
    }
}
