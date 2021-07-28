class Solution {
    public int minimumDeletions(String s) {
           if (s.length() == 1)
            return 0;
        int length = s.length();
        int [] suffixSum = new int [length];
        suffixSum[length-1] = s.charAt(length-1) == 'b' ? 0 : 1;
        for (int i=length-2; i>=0; i--) {
            if (s.charAt(i) == 'a') 
                suffixSum[i] = suffixSum[i+1] + 1;
            else
                suffixSum[i] = suffixSum[i+1];
        }
        int minimumSteps = Integer.MAX_VALUE;
        int countB = 0;
        for (int i=0; i<length; i++) {
            if (s.charAt(i) == 'b') {
                minimumSteps = Math.min(minimumSteps, countB + suffixSum[i]);
                countB += 1;
            }
        }
        minimumSteps = Math.min(minimumSteps, countB);
        return minimumSteps != Integer.MAX_VALUE ? minimumSteps : 0; 
    }
}