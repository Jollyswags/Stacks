class Solution {
   public boolean isOperator(String str)
    {
        char c = str.charAt(0);
        return (str.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/'));
    }
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        int a,b,c;
        
        for(int i=0; i<tokens.length; i++)
        {
            if(isOperator(tokens[i]))
            {
                b = st.pop();
                a = st.pop();
                
                char op = tokens[i].charAt(0);
                switch(op)
                {
                case '+':
                    c = a + b;
                    st.push(c);
                    break;
                case '-':
                    c = a - b;
                    st.push(c);
                    break;
                case '*':
                    c = a * b;
                    st.push(c);
                    break;
                case '/':
                    c = a/b;
                    st.push(c);
                    break;
                default:
                        return 0;
                
            }
        }
            else
                st.push(Integer.parseInt(tokens[i]));
        
    }
        return st.pop();
}
}