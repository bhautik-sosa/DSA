class Pair{
    String first;
    int second;
    public Pair(String first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList){
        // Code here
        Queue<Pair> q = new LinkedList<>();
        q.offer( new Pair(startWord , 1));
        
        Set<String> set = new HashSet<>();
        for( int i=0 ; i < wordList.length ; i++) set.add(wordList[i]);
        
        set.remove(startWord);
        
        while(!q.isEmpty()){
            StringBuilder word = new StringBuilder(q.peek().first);
            int step = q.peek().second;
            q.poll();
            if( word.toString().equals(targetWord)) return step;
            
            for( int i=0 ; i < word.length() ; i++){
                char original = word.charAt(i);
                for( char ch = 'a' ; ch <= 'z' ; ch++){
                    word.setCharAt(i , ch);
                    if(set.contains(word.toString())){
                        set.remove(word.toString());
                        q.offer( new Pair(word.toString() , step+1));
                    }
                }
                word.setCharAt(i , original);
            }
        }
        return 0;
    }
}
