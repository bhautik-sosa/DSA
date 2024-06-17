
class Solution{
    
    int MOD = 1000000007;
    
    public int perfectSum(int arr[], int n, int sum) {
        
        int[][] dp = new int[n][sum+1];
        for( int[] x : dp ) Arrays.fill( x , -1);
        
        // return helper( n-1 , sum, arr, dp)%MOD;
        if( arr[0] <= sum ) {
            dp[0][arr[0]] = 1;
        }

    }
    
    // Memoization : 
    public int helper(int ind , int sum , int[] arr, int[][] dp) {
        
        if( ind == 0 ){
            
            if( sum == 0 && arr[0] == 0 ) return 2;
            if( sum == 0 ) return 1;
            
            if( sum == arr[0] ) return 1;
            return 0;
        }
        
        if( dp[ind][sum] != -1 ) return dp[ind][sum];
        
        // Recursive calls
        int take = 0;
        if( arr[ind] <= sum ) take = helper(ind - 1, sum - arr[ind], arr , dp) % MOD; // Include current element
        int notTake = helper(ind - 1, sum, arr, dp) % MOD; // Exclude current element

        return dp[ind][sum] = (take%MOD + notTake%MOD) % MOD; // Sum both possibilities
    }
}
