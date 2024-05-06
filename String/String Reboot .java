
class Solution {
    public static boolean AreEqual(String a, String b) {
        // code here
        boolean flag = false;
        for( int i=0 ; i < a.length()-1 ; i++ ){
            char x = a.charAt(i);
            char y = a.charAt(i+1);
            
            if( x == '0' && y == '1'){
                if( b.charAt(i) == x && b.charAt(i+1) == y ) {
                    flag = true;
                    break;
                }
            }
        }
        
        return flag;
    }
}
