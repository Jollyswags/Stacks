class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> boolResQ = new LinkedList<>(); // stores results, bool flag and braces
        Deque<Character> operators = new LinkedList<>(); // stores operators
        int i = 0;
        boolean isFirst;
        char c;
        while (i < expression.length()){
            // add to operators and expression unless sub expression is encountered
            while( i < expression.length() && expression.charAt(i) != ')')
            {
                c = expression.charAt(i);
                if (c == '!' || c == '&' || c == '|')
                    operators.push(c);
                else if (c != ',')
                    boolResQ.push(c);
                i++;
            }
            char currOperator = operators.peek();
            // sub expression accumulator
            boolean prev = false;
            // flag to initialize result of sub expression
            isFirst = true;
            while (!boolResQ.isEmpty() && boolResQ.peek() != '('){
                boolean curr = (boolResQ.poll() == 't');
                if (isFirst){
                    // negate if '!'
                    prev = (currOperator == '!') != curr;
                    isFirst = false;
                    continue;
                }
                switch(currOperator){
                    case('!'): {
                        prev = !prev;
                        break;
                    }
                    case('|'): {
                        prev = prev || curr;
                        break;
                    }
                    case('&'): {
                        prev = prev && curr;
                        break;
                    }
                    default: break;
                }
            }
            // on reaching start of expression remove operator and bracket
            if (!boolResQ.isEmpty() && boolResQ.peek() == '('){
                operators.pop();
                boolResQ.pop();
            }
            // store the result of sub expression for total evaluation
            boolResQ.push(prev ? 't': 'f');
            i++;
        }
        return boolResQ.peek() == 't';
    }
}