class Solution {
    public String removeDuplicates(String a) {
        StringBuilder ans=new StringBuilder();
        Stack<Character> s=new Stack();
        int i;
        for(i=0;i<a.length();i++)
        {
            if(!s.isEmpty() && s.peek()==a.charAt(i))
            {
                s.pop();
            }
            else
            s.push(a.charAt(i));
        }
        while(!s.isEmpty())
            ans.append(s.pop());
        return ans.reverse().toString();
    }
}