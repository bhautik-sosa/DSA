
class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n){
        //Your code here
        
        HashMap<Long , Integer> map = new HashMap<>();
        map.put( 0l , 1);
        
        long sum = 0;
        long ans = 0;
        
        for( int i=0 ; i < arr.length ; i++ ){
            
            sum += arr[i];
            if( map.containsKey(sum) ){
                ans += map.get(sum);
            }
            
            map.put( sum , map.getOrDefault(sum , 0)+1);
        }
        
        return ans;
    }
}
