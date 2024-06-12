
class Solution{
    static int maximumPath(int n, int Matrix[][]){
        // code here
        
        int maxSum = 0;
        
        int[][] dp = new int[n][n];
        
        for( int[] x : dp ) Arrays.fill(x ,-1);
        
        // for( int i=n-1 ; i >= 0 ; i-- ){
            
        //     maxSum = Math.max( maxSum , helper( n-1 , i , Matrix , dp) );
        // }
        
        // return maxSum;
        
        
        // Tabulation :-
        
        
            // for( int i=0 ; i < n ; i++ ){
            //     dp[0][i] = Matrix[0][i];
            // }
            
            // for( int i=1 ; i < n ; i++) {
                
            //     for( int j = 0 ; j < n ; j++ ){
                    
            //         int up = Matrix[i][j] + dp[i-1][j];
            //         int left = 0;
            //         int right = 0;
                    
            //         if( j -1 >= 0)   left = Matrix[i][j] + dp[i-1][j-1];
            //         if( j + 1 < n )  right = Matrix[i][j] + dp[i-1][j+1];
                    
            //         dp[i][j] = Math.max( up , Math.max( left , right ));
            //     }
            // }
            
            // int ans = 0;
            // for( int i=0 ; i < n ; i++ ){
            //     ans = Math.max( ans , dp[n-1][i]);
            // }
            // return ans;
            
            
        // Space Optimized Approach :-
            
            int[] prev = new int[n];
            
            for( int i=0 ; i < n ; i++ ){
                prev[i] = Matrix[0][i];
            }
            
            for( int i=1 ; i < n ; i++ ){
                
                int[] cur = new int[n];
                for( int j = 0 ; j < n ; j++ ){
                    
                    int up =Matrix[i][j] + prev[j];
                    int left = 0 , right = 0;
                    
                    if( j > 0 ) left = Matrix[i][j] + prev[j-1];
                    if( j < n-1 ) right = Matrix[i][j] + prev[j+1];
                    
                    cur[j] = Math.max( up , Math.max( left, right));
                }
                
                prev = cur;
            }
            
            int ans = Arrays.stream(prev).max().getAsInt();
            
            return ans;
        
    }
    
    
        // Memoization :-
        
        static int helper( int row , int col , int[][] arr , int[][] dp){
            
            if( col < 0 || col >= arr.length) return 0;
            
            if( row == 0 ) return arr[row][col];
            
            if( dp[row][col] != -1 ) return dp[row][col];
            
            
            int up = arr[row][col] + helper( row-1 , col , arr , dp);
            int leftDiagonal = arr[row][col] + helper( row-1 , col-1 , arr , dp);
            int rightDiagonal = arr[row][col] + helper( row-1 , col+1 , arr, dp);
            
            return dp[row][col] =  Math.max( up , Math.max( leftDiagonal , rightDiagonal));
        }
}
