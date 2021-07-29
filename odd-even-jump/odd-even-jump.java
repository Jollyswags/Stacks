class Solution {
    public int oddEvenJumps(int[] arr) {
       int n = arr.length;
        if(n == 0) return 0;
        boolean[][] dp = new boolean[n][2];
        dp[n-1][0] = true; //odd
        dp[n-1][1] = true; //even
        int res = 1;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.put(arr[n-1], n-1);
        for(int i = n-2; i >= 0; i--) {
            Integer oddJumpToKey = m.ceilingKey(arr[i]);
            if(oddJumpToKey != null) {
                int oddJumpToIndex = m.get(oddJumpToKey);
                if(dp[oddJumpToIndex][1] == true) { //if odd jump is made from this index, even jump should be possible from the reaching index
                    dp[i][0] = true; //odd jump from this index is possible
                    res++; //only increase the count if this index can be a starting index i.e., odd jump is possible from this index.
                }
            }
            Integer evenJumpToKey = m.floorKey(arr[i]);
            if(evenJumpToKey != null) {
                int evenJumpToIndex = m.get(evenJumpToKey);
                if(dp[evenJumpToIndex][0] == true) { //if even jump is made from this index, odd jump should be possible from the reaching index
                    dp[i][1] = true; //even jump from this index is possible
                }
            }
            m.put(arr[i], i);
        }
        return res;   
    }
}