class Solution {
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();

        // int[][] dp = new int[n][m];
        // for( int[] x : dp ) Arrays.fill(x , -1);

        // return helper(n-1 , m-1 , s , t , dp);

    // Tabulation :-
        // int[][] dp = new int[n+1][m+1];

        // for( int i=0 ; i < m ; i++ ) dp[0][i] = 0;
        // for( int j=0 ; j < n ; j++ ) dp[j][0] = 1;

        // for( int i= 1 ; i <= n ; i++ ){

        //     for( int j =1 ; j <= m ; j++ ){

        //         if( s.charAt(i-1) == t.charAt(j-1)){
        //             int take = dp[i-1][j-1];
        //             int notTake = dp[i-1][j];

        //             dp[i][j] = take + notTake;
        //         }
        //         else {
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }

        // return dp[n][m];

    // Space Optimized :-

        int[] prev = new int[m+1];
        prev[0] = 1;
        for( int i=1 ; i <= n ; i++ ){

            int[] cur = new int[m+1];
            cur[0] = 1;
            for(int j=1 ; j <= m ; j++ ){

                if( s.charAt(i-1) == t.charAt(j-1)){

                    int take = prev[j-1];
                    int notTake = prev[j];

                    cur[j] = take + notTake;
                }
                else {
                    cur[j] = prev[j];
                }
            } 
            prev = cur;
        }

        return prev[m];
    }

    // Memoization :-
    public int helper( int i , int j , String s , String t , int[][] dp){

        // Base cases :
        if( j < 0 ) return 1;
        if( i < 0 ) return 0;

        if( dp[i][j] != -1 ) return dp[i][j];

        if( s.charAt(i) == t.charAt(j) ){

            int take = helper(i-1 , j-1 , s , t ,  dp);
            int notTake = helper(i-1 , j , s , t , dp);

            return dp[i][j] = take + notTake;
        }
        return dp[i][j] =  helper( i-1 , j , s, t , dp);
    }
}
