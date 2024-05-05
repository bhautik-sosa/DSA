
class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        int ind  = 0;
        while( ind < word.length()){
            map.put( word.substring(ind , ind+k) , map.getOrDefault(word.substring(ind , ind+k) , 0)+1);
            ind += k;
        }

        int maxCnt= Integer.MIN_VALUE;
        for( int cnt : map.values()){
            if( cnt > maxCnt ) maxCnt = cnt;
        }

        return (word.length() / k ) - maxCnt;
    }
}
