
class Solution{
    int longestUniqueSubsttr(String S){
        
        HashMap<Character , Integer> map = new HashMap<>();
        int l =0 , r=0;
        int st = 0;
        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        
        while(  r < S.length()){
            
            char c = S.charAt(r);
             
            while ( l < r && map.containsKey(c) ) {
                char t = S.charAt(l);
                map.remove(t);
                len--;
                l++;
            }
            
            if( !map.containsKey(c) ) {
                map.put( c ,1);
                len++;
            }
            maxLen = Math.max( maxLen , len);
            r++;
        }
        
        return maxLen;
    }
}
