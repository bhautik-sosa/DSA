class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        boolean flag = false;
        int st = 0;
        int end = 0;
        int sum = 0;
        for(int i=0 ; i< n ; i++){
            sum += arr[i];
            if(sum >= s ){
                end = i;
                while( sum > s && st < end){
                    sum -= arr[st];
                    st++;
                }
            }
            if(sum == s ) {
                flag = true;
                res.add(st+1);
                res.add( end +1 );
                break;
            }
        }
        if(!flag){
            res.add(-1);
        }
        return res;
    }
}
