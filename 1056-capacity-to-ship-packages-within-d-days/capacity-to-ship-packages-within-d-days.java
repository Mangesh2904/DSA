class Solution {

    int bs(int[] nums, int l, int h, int t){
        if(l > h) return l;
        int ans = t;
        int m = (l+h)/2;
        int c = 0;

        for(int i : nums){
            if(c + i <= m) c += i;
            else{
                ans--;
                c = i;
            }

            if(ans <= 0) break;
        }
        if(ans > 0) return bs(nums, l, m-1, t);

        return bs(nums, m+1, h, t); 

    }

    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int h = 0;

        for(int i : weights){
            l = Math.max(l, i);
            h += i;
        }

        return bs(weights, l, h, days);
    }
}