
class Solution{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n){
    	// code here 
    	
    	Stack<Integer> st = new Stack<>();
    	for( int i=n-1 ; i >= 0 ; i-- ) st.push(i);
    	
    	while( st.size() > 1 ){
    	    
    	    int first = st.pop();
    	    int second = st.pop();
    	    
    	    if( M[first][second] != 1 && M[second][first] == 1 ){
    	        st.push( first);
    	    }
    	    else if( M[first][second] == 1 && M[second][first] != 1  ){
    	        st.push(second);
    	    }
    	}
    	if( st.size() == 0 ) return -1;
    	int num = st.pop();
    	
    	// Final Checking whether the found num is Celebrity or Not. I have used Sum method for it. Can also Manually check. 
    	int row = 0, col = 0;
    	for( int i=0 ; i < n ; i++ ){
    	    row += M[num][i];
    	    col += M[i][num];
    	}
    	
    	return (row == 0 && col == n-1 ) ? num : -1; 
    }
}
