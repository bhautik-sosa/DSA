
class Solution {
    static long maxScore(int cardPoints[], int N, int k) {
        // code here
        long lSum = 0 , rSum = 0;
        
        
        for( int i=0 ; i < k ; i++ ){
            lSum += cardPoints[i];
        }
        
        long maxSum = lSum;
        int rInd = N-1;
        
        for( int i = k-1 ; i>= 0 ; i--){
            lSum -= cardPoints[i];
            
            rSum += cardPoints[rInd];
            rInd--;
            
            maxSum = Math.max( maxSum , lSum + rSum);
        }
        
        return maxSum;
    }
}
