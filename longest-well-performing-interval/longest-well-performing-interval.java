class Solution {
    public int longestWPI(int[] hours) {
         int sum=0;int max=0;int range=0; int diff=0;
        Map<Integer,Integer> map=new HashMap<>(); 
        
        for(int i=0;i<hours.length;i++) 
        {
            sum=sum+(hours[i]>8 ?1:-1);
            if(!map.containsKey(sum))
            {
                map.put(sum,i);
            }
            if(sum>0)
            {
                max=i+1;
            }
            if(map.containsKey(sum-1))
            {
                diff=i-map.get(sum-1);
                max=Math.max(max,diff);
            }
        }
        return max;
        
    }
}