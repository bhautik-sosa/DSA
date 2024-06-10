
class Pair{
    int st;
    int en;
    int pos;
    
    public Pair( int st , int en , int pos){
        this.st = st;
        this.en = en;
        this.pos = pos;
    }
}

class Solution{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n){
        // add your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>( (x , y) -> x.en - y.en);
        
        for( int i=0 ; i < n ; i++ ){
            pq.offer( new Pair( start[i] ,  end[i] , i));
        }
        
        int ans = 1;
        int freeTime = pq.poll().en;
        
        while( !pq.isEmpty()){
            
            Pair p = pq.poll();
            
            if( p.st > freeTime ) {
                ans++;
                freeTime = p.en;
            }
        }
        
        return ans;
    }
}
