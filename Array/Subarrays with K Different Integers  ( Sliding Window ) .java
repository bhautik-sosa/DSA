
class Solution {
    static int subarrayCount(int arr[], int N, int k) {
    // code here
        return helper(arr , k , N) - helper(arr , k-1 , N);   //  distict int <= k - distinct <= k-1 = exactly k distinct int. 
    }
    
    // Find the count of subarray with <= k integers.
    static int helper(int[] arr , int k , int n){
        
        int l = 0 , r = 0 , cnt = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        
        while( r < n ){
            
            map.put( arr[r] , map.getOrDefault( arr[r] , 0) + 1 );
            while( map.size() > k ){
                map.put( arr[l] , map.get(arr[l])-1);
                if( map.get(arr[l]) <= 0 ) map.remove(arr[l]);
                l++;
            }
            
            cnt += (r - l + 1);
            r++;
        }
        
        return cnt;
    }
}
