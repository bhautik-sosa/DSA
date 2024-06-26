
class Solution {
    static int findTargetSumWays( int N, int[] A ,int target) {
        // code here
        int sum =  0;
        for( int x : A ) sum += x;
        
        if (sum - target < 0)
            return 0;
        if ((sum - target) % 2 == 1)
            return 0;
        
        int s2 = (sum-target)/2;

        int[][] dp = new int[N][s2+1];
        
        for( int[] x : dp ) Arrays.fill( x , -1);
        
        return helper( N-1  , s2 , A , dp);
       
    }
    
    // Memoization :-
    
        // If we can get the two subarray with sum (totalsum-target)/2 , it is exactly same as given problem Statement
        static int helper(int ind, int target, int[] arr, int[][] dp) {
            // Base case: If we have reached the first element
            if (ind == 0) {
                // Check if the target is 0 and the first element is also 0
                if (target == 0 && arr[0] == 0)
                    return 2;
                // Check if the target is equal to the first element or 0
                if (target == 0 || target == arr[0])
                    return 1;
                return 0;
            }
    
            // If the result for this subproblem has already been calculated, return it
            if (dp[ind][target] != -1)
                return dp[ind][target];
    
            // Calculate the number of ways without taking the current element
            int notTaken = helper(ind - 1, target, arr, dp);
    
            // Initialize the number of ways taking the current element as 0
            int taken = 0;
    
            // If the current element is less than or equal to the target, calculate 'taken'
            if (arr[ind] <= target)
                taken = helper(ind - 1, target - arr[ind], arr, dp);
    
            // Store the result in the dp array and return it
            return dp[ind][target] = (notTaken + taken);
        }
};
