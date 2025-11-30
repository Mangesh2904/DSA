class Solution {

    int bs(int[] nums, int l, int h, int t){
        if(l > h) return l;

        int m = (l+h)/2;

        int a = 0;

        for(int i : nums) a += Math.ceil((double)i/m);

        if(a <= t) return bs(nums, l, m-1, t);

        return bs(nums, m+1, h, t);

    }



    public int minEatingSpeed(int[] piles, int h) {
        int m = Integer.MIN_VALUE;
        for(int i : piles) m = Math.max(m, i);
        return bs(piles, 1, m, h);
    }
}