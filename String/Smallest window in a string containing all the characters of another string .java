
class Solution{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p){
        // Your code here
        
        if( p.equals("")) return "-1";
        if( p.length() > s.length()) return "-1";
        if( s.equals(p)) return s;
        
        HashMap<Character , Integer> pMap = new HashMap<>();
        HashMap<Character , Integer> sMap = new HashMap<>();
        
        for( char c : p.toCharArray()) pMap.put( c , pMap.getOrDefault(c , 0)+1);
        
        int curLen = 0;
        int totLen = pMap.size(); 
        
        int l = 0 , r = 0;
        int resLen = Integer.MAX_VALUE;
        String ans = "-1";
        
        while( r < s.length()){
            char c = s.charAt(r);
            sMap.put( c , sMap.getOrDefault(c , 0)+1);
            
            if( pMap.containsKey(c) && pMap.get(c) == sMap.get(c) )
            curLen++;
            
            while( curLen == totLen ){
                
                if( (r - l + 1) < resLen ){
                    ans = s.substring( l , r+1);
                    resLen = r - l + 1;
                }
                
                char t = s.charAt(l);
                sMap.put( t , sMap.get(t) - 1);
                
                if( pMap.containsKey(t) && sMap.get(t) < pMap.get(t) ) curLen--;
                
                l++;
            }
            r++;
        }
        
        return resLen == Integer.MAX_VALUE ? "-1" : ans;
    }
}
