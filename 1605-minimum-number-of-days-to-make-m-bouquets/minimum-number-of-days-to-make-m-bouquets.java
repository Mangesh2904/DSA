class Solution {

    
    long bs(int[] nums, long l, long h, int t, int k){
        if(l > h) return l;
        int s = t;
        long m = (l+h) / 2;
        long c = 0;
        for(int i: nums){
            if(m - i >= 0) c++;
            else c = 0;

            if(c / k == 1){
                t--;
                c = 0;
            }

            if(t == 0) break;
        }
        if(t == 0) return bs(nums, l, m-1, s, k);
        return bs(nums, m+1, h, s, k);
    }



    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length/k < m) return -1;
        
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for(long i : bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if(bloomDay.length == m*k) return (int)max;

        return (int)bs(bloomDay, min, max, m, k);

    }
}