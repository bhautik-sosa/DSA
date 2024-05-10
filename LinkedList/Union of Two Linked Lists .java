/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol{
	public static Node findUnion(Node head1,Node head2){
	    //Add your code here.
	    
	    TreeSet<Integer> set = new TreeSet<>();
	    
	    Node t1 = head1 , t2 = head2;
	    while ( t1 != null ){
	        set.add(t1.data);
	        t1 = t1.next;
	    }
	    while( t2 != null ){
	        set.add(t2.data);
	        t2 = t2.next;
	    }
	    
	    Node dummy = new Node(-1);
	    Node res = dummy;
	    
	    for( int el : set){
	        Node newNode = new Node(el);
	        res.next = newNode;
	        res = res.next;
	    }
	    
	    res.next = null;
	    return dummy.next;
	}
}
