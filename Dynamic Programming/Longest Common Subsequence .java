
class Solution {
    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String str1, String str2) {
        // your code here
        // int[][] dp = new int[n][m];
        // for( int x[] : dp ) Arrays.fill(x , -1);
        
        // return helper( n-1 , m-1 , str1 , str2 , dp);
        
        // Tabulation :-
        
            // By shifting indexes one to right. for avoiding -1 index :
            
            // int[][] dp = new int[n+1][m+1];
            
            // // base case 
            // for( int i=0 ; i <= n ; i++ ){
                
            //     dp[i][0] = 0;
            // }
            // for( int j =0 ; j <= m ; j++ ){
                    
            //     dp[0][j] = 0;
            // }
            
            
            
            // for( int i=1 ; i <= n ; i++ ){
                
            //     for( int j = 1 ; j <= m ; j++ ){
                    
            //         if( str1.charAt(i-1) == str2.charAt(j-1) ) {
            //             dp[i][j] = 1 + dp[i-1][j-1];
            //         }
            //         else {
                        
            //             dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
            //         }
            //     }
            // }
            
            // return dp[n][m];
            
    // Space Optimization :-
    
            int[] prev = new int[m+1];
            // base case 
            for( int i=0 ; i <= m ; i++ )  prev[i] = 0;
            
            for( int i=1 ; i <= n ; i++ ){
                
                int[] cur = new int[m+1];
                
                for( int j = 1 ; j <= m ; j++ ){
                    
                    if( str1.charAt(i-1) == str2.charAt(j-1) ) {
                        cur[j] = 1 + prev[j-1];
                    }
                    else {
                        
                       cur[j] = Math.max( prev[j] , cur[j-1]);
                    }
                }
                
                prev = cur;
            }
            
            return prev[m];
    }
    
    // Memoization :-
    
    static int helper( int ind1 , int ind2 ,  String s1 , String s2 , int[][] dp){
         
        // Base case :-
        if( ind1 < 0 || ind2 < 0 ) return 0;
        
        if( dp[ind1][ind2] != -1 ) return dp[ind1][ind2];
        
        if( s1.charAt(ind1) == s2.charAt(ind2)){
            
            return dp[ind1][ind2] = 1 + helper( ind1-1 , ind2-1 , s1 , s2 , dp);
        }
        
        return dp[ind1][ind2] = Math.max( helper(ind1-1 , ind2 , s1 , s2 , dp) , helper(ind1 , ind2-1 , s1 , s2 , dp));
    }
}
