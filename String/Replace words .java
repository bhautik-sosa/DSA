
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        
        String[] arr = sentence.split("\\s");
        HashSet<String> set = new HashSet<>(dict);
        String ans = "";
        for( String s : arr ){
            ans += helper( s , set) + " ";
        }

        return ans.substring( 0 , ans.length()-1);
    }

    public String helper( String word , HashSet<String> set){

        for( int i = 1 ; i <= word.length() ; i++){
            String temp = word.substring(0, i);
            if( set.contains(temp) ) return temp;
        }

        return word;
    }
}
