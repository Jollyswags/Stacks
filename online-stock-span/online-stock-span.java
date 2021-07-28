class StockSpanner {

    Stack<int[]> stack;
    
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 0;
        while(!stack.isEmpty() && stack.peek()[0]<= price){
            count+=stack.pop()[1];
        }
        count++;
        stack.push(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */