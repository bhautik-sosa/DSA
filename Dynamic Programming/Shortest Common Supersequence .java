
class Solution{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){
        //Your code here
        // common part will calculated only once so we will minus the common part from total length.
        return (n + m) - lcs(X ,  Y , m , n);
    }
    
    public static int lcs( String str1 , String str2 , int n , int m){
        
        int[][] dp = new int[n+1][m+1];
            
            // // base case 
            for( int i=0 ; i <= n ; i++ ){
                
                dp[i][0] = 0;
            }
            for( int j =0 ; j <= m ; j++ ){
                    
                dp[0][j] = 0;
            }
            
            
            
            for( int i=1 ; i <= n ; i++ ){
                
                for( int j = 1 ; j <= m ; j++ ){
                    
                    if( str1.charAt(i-1) == str2.charAt(j-1) ) {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else {
                        
                        dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
                    }
                }
            }
            
            return dp[n][m];
    }
}
