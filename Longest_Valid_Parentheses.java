/*

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


*/


public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char[] cs = s.toCharArray();
        int count=0,end=s.length(),tmp;
        st.push(-1);
        for(int i=0;i<cs.length;i++){
            if(cs[i]=='(')
                st.push(i);
            else{
                    st.pop();
                    if(!st.empty())
                    count = Math.max(count,i-st.peek());
                    else{
                    st.push(i);
                    }
                }
            }
        if(!st.empty()){
            tmp=st.pop();
            count = count>(end-tmp-1)?count:(end-tmp-1);        
        }
        return count;
    }
}
