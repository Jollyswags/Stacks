class Solution {
    public int maximumGain(String s, int x, int y) {
              int total = 0;
        boolean ab = (x>y);
        Deque<Character> stack = new ArrayDeque<>();
        Stack<Character> stack2 = new Stack<>();
        
       
        for(char ch: s.toCharArray()) {
            if(!stack.isEmpty()) {
                if(ab) {
                    if(stack.peek() == 'a' && ch == 'b') {
                        total += x;
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                } else {
                    if(stack.peek() == 'b' && ch == 'a') {
                        total += y;
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            } else {
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()) {
            char ch = stack.removeLast(); 
            
            if(!stack2.empty()) {
                if(!ab) {
                    if(stack2.peek() == 'a' && ch == 'b') {
                        total += x;
                        stack2.pop();
                    } else {
                        stack2.push(ch);
                    }
                } else {
                    if(stack2.peek() == 'b' && ch == 'a') {
                        total += y;
                        stack2.pop();
                    } else {
                        stack2.push(ch);
                    }
                }
            } else {
                stack2.push(ch);
            }
        }
        
        
        return total ;
    }
}