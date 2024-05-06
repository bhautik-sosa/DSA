class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        helper(s, 0, ans, path );
        return ans;
    }

    public void helper( String s, int ind ,List<List<String>> ans, List<String> path){

        if( ind == s.length() ){
            ans.add(new ArrayList<>(path));
            return;
        }

        for( int i = ind ; i < s.length() ; i++ ){
            if( isPalindrome( s, ind , i)){
                path.add( s.substring( ind , i+1));
                helper( s , i+1 , ans , path );
                path.remove( path.size()-1);
            }
        }
    }

    public boolean isPalindrome( String s, int st , int end){
        while( st <= end ){
            if( s.charAt(st) != s.charAt(end) ) return false;
            st++;
            end--;
        }
        return true;
    }
}
