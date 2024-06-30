
class Solution{
    public int longestPalinSubseq(String s){
        //code here
        
        StringBuilder temp = new StringBuilder(s);
        String t = temp.reverse().toString();
        
        int n = s.length();
        // int[][] dp = new int[n][n];
        // for( int[] x : dp ) Arrays.fill(x , -1);
        
        // return helper( n-1 , n-1 , s , t , dp);
        
        
        // Tabulation :-
        
                int[][] dp = new int[n+1][n+1];
                
                for( int i=0 ; i <= n ; i++ ) dp[0][i] = 0;
                for( int j =0 ; j <= n ; j++ ) dp[j][0] = 0;
                
                int ans = 0;
                
                for( int i=1 ; i <= n ; i++ ){
                    
                    for( int j=1 ; j <= n ; j++ ){
                        
                        if( s.charAt(i-1) == t.charAt(j-1) ){
                            dp[i][j] = 1 + dp[i-1][j-1];
                            ans = Math.max( ans , dp[i][j]);
                        }
                        else {
                            
                            dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
                        }
                    }
                }
                
                return ans;
    }
    
    // Memoization :-
    
        public int helper(int ind1 , int ind2 , String s , String t , int[][] dp) {
            
            // Base case :-
            if( ind1 < 0 || ind2 < 0 ) return 0;
            
            if( dp[ind1][ind2] != -1 ) return dp[ind1][ind2];
            
            if( s.charAt(ind1) == t.charAt(ind2) ){
                
                return 1 + helper( ind1-1 , ind2-1 , s , t , dp);
            }
            
            return dp[ind1][ind2] = Math.max( helper(ind1-1 , ind2 , s , t , dp) , helper(ind1 , ind2-1 , s , t , dp));
        }
}
