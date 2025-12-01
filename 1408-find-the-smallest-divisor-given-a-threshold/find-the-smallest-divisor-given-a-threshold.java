class Solution {

    int bs(int[] nums, int l, int h, int t){
        if(l > h) return l;
        int a = 0;
        int m = (l+h)/2;
        for(int i : nums){
            a += Math.ceil((double)i/m);
        }
        if(a > t) return bs(nums, m+1, h, t);
        return bs(nums, l, m-1, t);
    }            

    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        
        if(threshold == nums.length) return max;
        if(threshold == sum) return 1; 
        return bs(nums, 1, max, threshold);
    }
}