class Solution {
    public String decodeString(String s) {
           Stack<Integer> is = new Stack<>();
        Stack<String> ss = new Stack<>();
        
        String curr = "";
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                int num = 0;
                while(Character.isDigit(s.charAt(i))) {
                    num = num*10 + s.charAt(i)-'0';
                    i += 1;
                }
                i -= 1;
                is.push(num);
            } else if(ch == '[') {
                ss.push(curr);
                curr = "";
            } else if(ch == ']') { 
                String tmp = ss.pop();        
                int count = is.pop(); 
                for(int c = 0; c < count; c++) {
                    tmp += curr;
                }
                curr = tmp;
            } else {
                curr += s.charAt(i);
            }
        }
        
        return curr;
        
    }
}