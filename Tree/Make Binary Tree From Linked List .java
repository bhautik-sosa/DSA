
/*class Tree{
int data;
    Tree left;
    Tree right;
    Tree(int d){
        data=d;
        left=null;
        right=null;
    }
}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/


class GfG {
    //Function to make binary tree from linked list.
    public static Tree convert(Node head, Tree node) {
        // add code here.}
        ArrayList<Tree> V=new ArrayList<>();
        
        Node temp=head;
        while(temp!=null){
            Tree treenode=new Tree(temp.data);
            V.add(treenode);
            temp=temp.next;
        }

        int n=V.size();
        for(int i=0;i<n/2;i++){
            if((2*i+1)<n){
               V.get(i).left=V.get(2*i+1);
            }
            if((2*i+2)<n){
                V.get(i).right=V.get(2*i+2); 
            }
        }
        
        return V.get(0);
    }
}
