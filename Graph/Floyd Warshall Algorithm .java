class Solution{
    public void shortest_distance(int[][] matrix){
        // Code here 
        int n = matrix.length;
        // int m = matrix[0].length;
            
        for( int j =0 ; j < n ; j++ ){
            
            for( int k =0 ; k < n ; k++){
                
                if( matrix[j][k] == -1 ) matrix[j][k] = Integer.MAX_VALUE;
                
                if( j == k ) matrix[j][k] = 0;
            }
        }
        
        for( int via = 0 ; via < n ; via++ ){
            for( int i =0 ; i < n ; i++ ){
                for( int j =0 ; j < n ; j++){
                    
                    if (matrix[i][via] != Integer.MAX_VALUE && matrix[via][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                    }
                }
            }
        }
        
        for( int j =0 ; j < n ; j++ ){
            
            for( int k =0 ; k < n ; k++){
                
                if( matrix[j][k] == Integer.MAX_VALUE ) matrix[j][k] = -1;
            }
        }
    }
}
