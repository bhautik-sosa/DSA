
class Solution{
	public int minOperations(String str1, String str2){ 
	    // Your code goes here
	    int n = str1.length() , m = str2.length();
	    return (n+m) - 2*(lcs(str1 , str2));
	    
	    // Insertion = len of string1 - lcs(string1 , string2)
	    // Deletion = len of string2 - lcs( string1 , string2)
	    
	    // Total minimum changes = Insertion + Deletion 
	    //                       = len of string1 + len of string2 - 2*( lcs(string1 , string2))
	} 
	
	public int lcs( String str1 , String str2){
	    
	    int n = str1.length();
	    int m = str2.length();
	    
        int[][] dp = new int[n+1][m+1];
        
        // base case 
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
