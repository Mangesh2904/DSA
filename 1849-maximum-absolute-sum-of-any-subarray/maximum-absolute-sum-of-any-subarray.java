class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int s1 = 0, max = 0, min = 0, s2 = 0;
        for(int i : nums){
            
            s1 += i;
            max = Math.max(max, s1);

            if(s1 < 0) s1 = 0;
            
            s2 += i;
            min = Math.min(min, s2);

            if(s2 > 0) s2 = 0;

        }

        return Math.max(max, Math.abs(min));
    }
}