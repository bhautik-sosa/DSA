
class Solution {
    static int minRemoval(int N, int intervals[][]) {
        // code here
        Arrays.sort( intervals , Comparator.comparingInt( (int[] p) -> p[1]));
        
        int freeTime = intervals[0][1];
        int ans = 1;
        
        for( int i=1 ; i < N ; i++ ){
            
            if( intervals[i][0] >= freeTime ){
                ans++;
                freeTime = intervals[i][1];
            }
        }
        
        return N - ans;
    }
}
