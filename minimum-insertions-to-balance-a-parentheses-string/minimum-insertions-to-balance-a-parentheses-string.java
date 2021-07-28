class Solution {
    public int minInsertions(String s) {
      Stack<Character> stk=new Stack<Character>();
        int bal=0;
        for(int i=0;i<s.length();)
        {
            if(s.charAt(i)=='(')
            {
                stk.push(s.charAt(i));
                i++;
            }
            else 
            {
           
                if(stk.empty())
                {
                   
                    if(i+1<s.length() && s.charAt(i+1)==')')
                    {
                        bal++;
                        i+=2;
                    }
                   
                    else
                    {
                        bal+=2;
                        i++;
                    }
                }
   
                else
                {
                   
                    if(i+1<s.length() && s.charAt(i+1)==')')
                    {
                        i+=2;
                    }
                
                    else
                    {
                        bal++;
                        i++;
                    }
                    stk.pop();
                }
            }
        }
        
        while(!stk.empty())
        {
            stk.pop();
            bal+=2;
        }
        return bal;  
    }
}