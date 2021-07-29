class Solution {
    public int calculate(String s) {
          int result = 0;
        if(s != null && s.length() > 0){
            int num = 0;
            char lastOper = '+';
            Stack<Object> stack = new Stack();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);                
                if(Character.isDigit(c)){
                    num = num*10 + c - '0';
                }
                if(c == '('){
                    stack.push(lastOper == '+' ? 1 : -1);
                    stack.push("(");
                    lastOper = '+';
                    num = 0;
                }
                if(c == '+' || c == '-' || c == ')' || i == s.length()-1){
                    stack.push(lastOper == '+' ? 1*num : -1*num);
                    lastOper = c;
                    num = 0;
                    if(c == ')'){
                        int subTotal = 0;
                        while(!stack.isEmpty() && !stack.peek().equals("(")){
                            subTotal = subTotal + (Integer)stack.pop();
                        }
                        stack.pop(); // remove the open brace
                        int sign = stack.isEmpty() ? 1 : (Integer)stack.pop();
                        stack.push(sign*subTotal);
                    }
                }
            }
            while(!stack.isEmpty()){
                result = result + (Integer)stack.pop();
            }
        }
        return result;
    }
}