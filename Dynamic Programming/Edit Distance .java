
class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int n = s.length();
        int m = t.length();
        // int[][] dp = new int[n][m];
        
        // for( int[] x : dp ) Arrays.fill( x , -1);
        // return helper( n-1 , m-1 , s , t , dp);
        
        
    // Tabulation :-
    
        int[][] dp = new int[n+1][m+1];
        for( int i=0 ; i <= n ; i++) dp[i][0] = i;
        for( int j=0 ; j <= m ; j++) dp[0][j] = j;
        
        for( int i =  1 ; i <= n ; i++ ){
            
            for( int j = 1 ; j <= m ; j++ ){
                
                if( s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    
                    dp[i][j] = Math.min( insert , Math.min( delete , replace));
                }
            }
        }
        
        return dp[n][m];
    }
    
    // Memoization :-
    public int helper( int i , int j , String s , String t , int[][] dp){
        
        // Base cases :-
        if( i < 0 ) return j+1;
        if( j < 0 ) return i+1;
        
        if( dp[i][j] != -1 ) return dp[i][j];
        
        if( s.charAt(i) == t.charAt(j) ) return helper( i-1 , j-1 , s , t , dp);
        
        int insert = 1 + helper( i , j-1 , s , t , dp);
        int delete = 1 + helper( i-1 , j , s  , t , dp);
        int replace = 1 + helper( i-1 , j-1 , s , t, dp);
        
        return dp[i][j] =  Math.min( insert , Math.min( delete , replace ));
    }
}
