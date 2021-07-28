class Solution {
    public int maxWidthRamp(int[] nums) {
       int len = nums.length;
        int max = Integer.MIN_VALUE;
        
        Stack<Integer> st = new Stack();
        
        for(int i=0;i<len;i++) {
            if(st.isEmpty() || nums[i] <nums[st.peek()]) {
                st.push(i);
            }
        }
        
        for(int i=len-1;i>=0;i--) {
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]) {
                int diff = i - st.pop();
                
                System.out.println(diff);
                max = Math.max(max, diff);
            }
        }
        
        return max==Integer.MIN_VALUE?0:max; 
    }
}