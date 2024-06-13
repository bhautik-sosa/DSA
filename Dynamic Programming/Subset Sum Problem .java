
class Solution{


    static Boolean isSubsetSum(int n, int arr[], int k){
        // code here
        // int[][] dp = new int[n+1][k+1];
        // for( int x[] : dp ) Arrays.fill( x , -1);
        
        // return helper(n-1 , k , arr , dp);
        
        
        // Tabulation :-
        
            boolean dp[][] = new boolean[n][k + 1];
            
            // Initialize the first row of the DP table
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }
    
            // Initialize the first column of the DP table
            if (arr[0] <= k) {
                dp[0][arr[0]] = true;
            }
    
    
            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= k; target++) {
                    
                    boolean notTaken = dp[ind - 1][target];
                    
                    
                    boolean taken = false;
                    if (arr[ind] <= target) {
                        taken = dp[ind - 1][target - arr[ind]];
                    }
                    
                    dp[ind][target] = notTaken || taken;
                }
            }
    
            // The final result is stored in the bottom-right cell of the DP table
            return dp[n - 1][k];
    }
    
    // Memoization :-
    
        static boolean helper( int ind , int target , int[] arr , int[][] dp){
            
            if( target == 0 ) return true;
            
            if( ind == 0 ) return arr[ind] == target;
            
            if( dp[ind][target] != -1 ) return dp[ind][target] == 1;
            
            boolean notPick = helper( ind-1 , target , arr , dp);
            boolean pick = false;
            if( arr[ind] <= target ) pick = helper( ind-1 , target-arr[ind] , arr , dp);
            
            boolean ans = notPick || pick;
            
            dp[ind][target]  = ans == true ? 1 : 0;
            
            return ans;
        }
}
