class Solution {

    int bs(int[] nums, int l, int h, int t){
        
        if(l > h) return l;

        int m = (l+h)/2, c = 1, s = 0;

        for(int i : nums){
            s += i;
            if(s > m){
                c++;
                s = i;
            }
        }

        if(c > t) return bs(nums, m+1, h, t);

        return bs(nums, l, m-1, t);

    }

    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE, h = 0;

        for(int i : nums){
            l = Math.max(l, i);
            h += i;
        }   
        if(k == nums.length) return l;
        return bs(nums, l, h, k);
    }
}