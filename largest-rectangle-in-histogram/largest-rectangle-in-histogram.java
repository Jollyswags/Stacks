class Solution {
    public int largestRectangleArea(int[] heights) {
         int[] leftLimits = new int[heights.length];
        int[] rightLimits = new int[heights.length];
        
        Stack<Integer> stack = new Stack<Integer>();
		//Left limit for first element is always the first element, hence pushing the first index straight away.
        stack.push(0);
        leftLimits[0]=0;
        
        for(int i=1;i<heights.length;i++){
		   //pop until we get a smallest element
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                leftLimits[i] = stack.pop();
            }
			//In case of smallest next block on the left at index i, the maximum possible consideration is till i+1
			//Also, in case the stack is empty, we can see that we have traversed all possibilities, and hence left limit is zero.
            leftLimits[i]= stack.isEmpty()?0:stack.peek()+1;
            stack.push(i);
        }
        
        stack.clear();
		//Right limit for last element is always the last element, hence pushing the last index straight away.
        stack.push(heights.length-1);
        
        rightLimits[heights.length-1]=heights.length-1;
        
        for(int i=heights.length-2;i>=0;i--){
		   //pop until we get a smallest element
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                rightLimits[i] = stack.pop();
            }
			//In case of smallest next block on the right at index i, the maximum possible consideration is till i-1.
			//Also, in case the stack is empty, we can see that we have traversed all possibilities, and hence left limit is the last index.
            rightLimits[i] = stack.isEmpty()?heights.length-1:stack.peek()-1;
            stack.push(i);
        }
        
        int maxArea = 0;
		//apply the formula and find the max area among all blocks.
        for(int i=0;i<heights.length;i++){
            int area = heights[i] * (rightLimits[i] - leftLimits[i] + 1);
            maxArea = Math.max(maxArea,area);
        }
        
        return maxArea;
    }
}