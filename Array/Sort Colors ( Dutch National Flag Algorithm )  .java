
class Solution {
    public void sortColors(int[] nums) {
        
        // int zeros = 0 , ones = 0 , twos = 0;

        // for( int x : nums ){
        //     if( x == 0 ) zeros++;
        //     else if( x == 1 ) ones++;
        //     else twos++;
        // }

        // for( int i=0 ; i < nums.length ; i++ ){
            
        //     if(  zeros != 0 ){
        //         nums[i] = 0;
        //         zeros--;
        //     }
        //     else if( ones != 0 ){
        //         nums[i] = 1;
        //         ones--;
        //     }
        //     else {
        //         nums[i] = 2;
        //     }
        // }

        // Dutch National Flag Algorithm :-
        
            int low = 0 , mid = 0 , high = nums.length-1;

            while( mid <= high ){
                
                if( nums[mid] == 0 ){
                    int temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;

                    low++;
                    mid++;
                }
                else if( nums[mid] == 1) mid++;
                else {
                    int temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                }
            }
    }
}
