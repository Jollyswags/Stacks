class Solution {
    public String makeGood(String s) {
        Stack<Character> st=new Stack();
        int i;
        StringBuilder ans=new StringBuilder();
        for(i=0;i<s.length();i++)
        {
        if(!st.isEmpty() && (st.peek()+32==s.charAt(i) || st.peek()-32==s.charAt(i)))
            st.pop();
            else
                st.push(s.charAt(i));
        }
        while(!st.isEmpty())
            ans.append(st.pop());
        return ans.reverse().toString();
    }
}