class Solution {

    int bs(int[] nums, int l, int h, int t, int ans){
        if(l > h) return ans;

        int m = (l + h)/2;

        if(nums[m] >= t){
            ans = Math.min(ans, m);
            return bs(nums, l, m-1, t, ans);
        }

        return bs(nums, m+1, h, t, ans);

    }

    public int searchInsert(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target, nums.length);
    }
}