class Solution {
    int missingNumber(int arr[], int n) {
        
        // Your Code Here
        
        // By Using Sum Formula :
        
            int sumArr = 0;
            int sumOfN = ( n*(n+1) )/2;
            
            for( int x : arr ){
                
                sumArr += x;
            }
            
            return sumOfN - sumArr;
            
        //By using XOR :
        
            // int xor1 = 0 , xor2 = 0;
            
            // for( int i=0 ; i < n-1 ; i++ ){
            //     xor1 ^= arr[i];
            //     xor2 ^= (i+1);
            // }
            // xor2 ^= n;
            
            // return xor2 ^ xor1;
    }
}
