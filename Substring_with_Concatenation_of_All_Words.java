/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class Solution {
   public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        int len = words[0].length();
        if(s.length()<words.length*len)
            return res;
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        String tmp;
        for(int i=0;i<words.length;i++){
            map2.put(words[i],map2.getOrDefault(words[i],0)+1);
        }
        map = (HashMap) map2.clone();
        int p=0,start=0,end=len,count;
        count=map.size();
        for(p=0;p<len;p++){
            start=p;
            end = start+len;
            map = (HashMap) map2.clone();            
            count=map.size();        
            while(end<=s.length()){
                tmp=s.substring(end-len,end);
                if(map.containsKey(tmp)){
                    map.put(tmp,map.get(tmp)-1);
                    if(map.get(tmp)==0)
                        count--;
                }
                   while(count==0){
                       if(end-start==words.length*len)
                           res.add(start);
                       tmp = s.substring(start,start+len);
                       if(map.containsKey(tmp)){
                           map.put(tmp,map.get(tmp)+1);
                           if(map.get(tmp)>0)
                               count++;
                       }
                       start +=len;
                   }
                end += len;
            }            
        }
        return res;       
    }
}
