
class Solution{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z){
       //Your code here
       if( x > n && y > n && z > n ) return 0 ;
       
       int[] dp = new int[n+1];
       Arrays.fill( dp , 0);
       int ans = helper( n , x , y , z , dp);
       return ans < 0 ? 0 : ans;
    }
    
    // Memorization :- 
    
        public int helper( int n , int x , int y , int z, int[] dp){
            
            if( n == 0 ) return 0;
            if( n < 0 ) return 0;
            if( dp[n] != -1 ) return dp[n];
            
            int selX = Integer.MIN_VALUE;
            int selY = Integer.MIN_VALUE;
            int selZ = Integer.MIN_VALUE;
            
            if( x <= n )  selX = 1 + helper(n - x , x , y , z, dp);
            if( y <= n )  selY = 1 + helper(n - y , x , y , z, dp);
            if( z <= n )  selZ = 1 + helper(n - z , x , y , z, dp);
            
            return dp[n] = Math.max( selX , Math.max(selY , selZ));
        }
}
