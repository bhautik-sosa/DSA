
class Solution {
    public static int minJumps(int n, int[] arr) {
        // code here
         
        HashMap<Integer , Integer> map = new HashMap<>();
        int ans = n-1;
        for( int i= n-1 ; i >= 0 ; i--){
            if( map.containsKey(arr[i])){
                ans = Math.min( ans ,  n - ( map.get(arr[i]) - i) );
                continue;
            }
            map.put( arr[i] , i);
        }
        return ans;
    }
}
