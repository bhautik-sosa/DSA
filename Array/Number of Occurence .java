
class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int low = 0;
        int high = n-1;
        
        int stInd = 0 , endInd = -1;
        
        while( low <= high){
            int mid = low + (high - low)/2;
            if( arr[mid] == x ){
                stInd = mid;
                high = mid-1;
            }
            else if( arr[mid] < x ) {
                low++;
            }
            else if( arr[mid] > x ) {
                high--;
            }  
        }
        
        low = 0;
        high = n-1;
        
        while( low <= high){
            
            int mid = low + (high - low)/2;
            if( arr[mid] == x ){
                endInd = mid;
                low = mid + 1;
            }
            else if( arr[mid] < x ) {
                low++;
            }
            else if( arr[mid] > x ) {
                high--;
            }  
        }
        // System.out.println(stInd + " " + endInd);
        return endInd - stInd + 1;
    }
}
