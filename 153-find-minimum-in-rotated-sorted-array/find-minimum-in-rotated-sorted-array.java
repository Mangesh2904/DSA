class Solution {

    int bs(int l, int h, int[] nums){

        if(l == h) return l;

        int m = (l + h) / 2;

        if(nums[m] <= nums[h]) return bs(l, m, nums);

        return bs(m + 1, h, nums);
    }

    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;

        int idx = bs(l, h, nums);

        return nums[idx];
    }
}