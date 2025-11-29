class Solution {

    int bs(int[] nums, int l, int h){
        if(l > h) return -1;

        int m = (l+h)/2;

        if(nums[m] > nums[m-1] && nums[m] > nums[m+1]) return m;
        else if(nums[m] > nums[m-1]) return bs(nums, m+1, h);
        else return bs(nums, l, m-1);
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if((n == 1) || (nums[0] > nums[1])) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        return bs(nums, 1, n-2);
    }
}