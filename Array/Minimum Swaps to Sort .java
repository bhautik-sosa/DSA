
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]){
        // Code here
        int n = nums.length;
        int[] temp = Arrays.copyOfRange(nums, 0 , n );
        HashMap<Integer , Integer> map = new HashMap<>();
        for( int i=0 ; i < n ; i++ ){
            map.put( nums[i] , i);
        }
        
        
        Arrays.sort(temp);
        int ans = 0;
        for( int i=0 ; i < n ; i++){
            
            
            if( nums[i] != temp[i]) {
                
                int x = nums[i];
                ans++;
                swap( nums , i , map.get(temp[i]));
                
                map.put( x , map.get(temp[i]));
                map.put( temp[i] , i);
            }
        }
        
        return ans;
    }

    public void swap( int[] arr, int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
