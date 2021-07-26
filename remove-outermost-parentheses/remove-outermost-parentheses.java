class Solution {
    public String removeOuterParentheses(String a) {
        int l=0;
        StringBuilder s=new StringBuilder();
        Stack<Character> st=new Stack();
        int i;
        for(i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='(')
            {
               st.push('('); 
              s.append(a.charAt(i));
               // System.out.println(s);
            }
                
            else
                if(a.charAt(i)==')')
                {
                      st.pop();
                     s.append(a.charAt(i));
                     //System.out.println(s);
                }
                  
    
                if(st.isEmpty())
                {
                    s=s.deleteCharAt(l);
                    
                    s=s.deleteCharAt(s.length()-1);
                    l=s.length();
                }
        }
        return s.toString();
        
    }
}