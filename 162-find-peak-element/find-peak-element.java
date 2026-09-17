class Solution {

    int bs(int l, int r, int[] nums){
        int n = nums.length;

        int m = (l + r) / 2;

        if(nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) return m;

        if(nums[m] > nums[m - 1]) return bs(m + 1, r, nums);

        return bs(l, m - 1, nums);
    }


    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n == 1 || nums[0] > nums[1]) return 0;

        if(nums[n - 1] > nums[n - 2]) return n - 1;

        return bs(1, n - 2, nums);
    }
}