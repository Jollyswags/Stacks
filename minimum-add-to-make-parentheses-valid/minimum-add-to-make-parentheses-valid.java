class Solution {
    public int minAddToMakeValid(String S) {
       Stack<Character> s=new Stack();
        int i,c=0;
        for(i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='(')
                s.push('(');
            else
                if(!s.isEmpty())
                    s.pop();
            else
                c++;
        }
        while(!s.isEmpty())
        {
            c++;
            s.pop();
        }
        return c;
    }
}