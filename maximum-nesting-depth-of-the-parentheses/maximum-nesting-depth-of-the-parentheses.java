class Solution {
    public int maxDepth(String S) {
        int i=0,d=0,max=0;
        Stack<Character> s=new Stack();
        while(i<S.length())
        {
            if(S.charAt(i)=='(')
            {
                s.push(S.charAt(i));
                d++;
                max=Math.max(max,d);
            }
            else
                if(S.charAt(i)==')')
                {
                    s.pop();
                    d--;
                }
            i++;
        }
        return max;
        
    }
}