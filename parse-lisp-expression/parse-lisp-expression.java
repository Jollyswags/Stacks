class Solution {
     class Exp {
        Stack<Exp> exps;
        String op;
        Exp parent;

        Exp(Exp from) {
            this.exps = new Stack<>();
            this.parent = from;
        }

        int evaluate(Map<String, Integer> vars) {
            if (op.equalsIgnoreCase("add")) {
                return exps.pop().evaluate(vars) + exps.pop().evaluate(vars);
            } else if (op.equalsIgnoreCase("mult")) {
                return exps.pop().evaluate(vars) * exps.pop().evaluate(vars);
            } else if (op.equalsIgnoreCase("let")) {
                Map<String, Integer> nextVars = new HashMap<>(vars);
                while (exps.size()>1) {
                    String varName = exps.pop().op;
                    int val = exps.pop().evaluate(nextVars);
                    nextVars.put(varName, val);
                }
                return exps.pop().evaluate(nextVars);
            } else {
                if (Character.isLetter(op.charAt(0))) {
                    return vars.get(op);
                } else {
                    return Integer.parseInt(op);
                }
            }
        }
    }
    
    Exp buildTree(String exp) {
        Exp root = new Exp(null), cur = root;
        int n = exp.length()-1;
        while (n >=0) {
            char c = exp.charAt(n);
            if (c==')') {
                Exp next = new Exp(cur);
                cur.exps.push(next);
                cur = next;
            } else if (c=='(') {
                cur.op = cur.exps.pop().op;
                cur = cur.parent;
            } else if (c != ' '){
                int pre = n;
                while (pre>=0 && exp.charAt(pre)!='(' && exp.charAt(pre)!=' ')
                    pre--;
                Exp next = new Exp(cur);
                next.op = exp.substring(pre+1, n+1);
                cur.exps.push(next);
                n=pre+1;
            }
            n--;
        }
        return root.exps.pop();
    }
    
    public int evaluate(String exp) {
        return buildTree(exp).evaluate(new HashMap<>());
    }
}