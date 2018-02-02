/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false


*/

public class Solution {
    public boolean isMatch(String s, String p) {  
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0]=true;
        for(int j=0;j<p.length();j++){
            if(p.charAt(j)=='*')
                match[0][j+1]=match[0][j];
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i))
                    match[i+1][j+1] = match[i][j];
                if(p.charAt(j)=='*'){
                    match[i+1][j+1] = match[i+1][j]||match[i][j]||match[i][j+1];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
