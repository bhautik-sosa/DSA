
class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        
        int[] min = new int[n];
        int[] max = new int[n];
        
        min[0] = arr[0];
        for( int i=1 ; i < n ; i++ ){
            min[i] = Math.min( min[i-1] , arr[i]);
        }
        
        max[n-1] = arr[n-1];
        for( int i = n-2 ; i >= 0 ; i--){
            max[i] = Math.max( max[i+1] , arr[i]);
        }
        
        int i =0 , j =0 , ans = 0;
        
        while( i < n && j < n){
            if( min[i] <= max[j]){
                ans = Math.max( ans , j-i);
                j++;
            }
            else i++;
        
        }
        return ans;
    }
}
