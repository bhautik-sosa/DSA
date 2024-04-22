class Pair{
    int first;
    int second;
    public Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int mod = 100000;
        int[] dist = new int[(int)1e5];
        Arrays.fill( dist , Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.offer( new Pair( 0 , start));
        
        while( ! q.isEmpty()){
            
            Pair p = q.poll();
            int steps = p.first;
            int el = p.second;
            if( el == end ) return steps;
            
            for (int it : arr) {
                int num = (it * el) % mod;
                if( steps + 1 < dist[num] ){
                    dist[num] = steps +  1;
                    q.offer( new Pair( steps + 1 , num ));
                }
            }
        }
        return -1;
    }
}
