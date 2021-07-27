class Solution {
    public int[] finalPrices(int[] prices) {
 
        int i;
        Stack<Integer> s=new Stack();
        for(i=0;i<prices.length;i++)
        {
            while(!s.isEmpty() && prices[s.peek()]>=prices[i])
            {
                prices[s.peek()]=prices[s.peek()]-prices[i];
                s.pop();
            }
            s.push(i);
            
        }
        return prices;
    }
}
//monotone stack