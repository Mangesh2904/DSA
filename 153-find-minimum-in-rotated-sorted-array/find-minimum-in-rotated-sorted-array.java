class Solution {

    int bs(int[] nums, int l, int h, int ans){
        if(l > h) return ans;

        int m = (l+h)/ 2;
        if(nums[m] < nums[h]){
            ans = Math.min(ans, nums[m]);
            return bs(nums, l, m-1, ans);
        }
        else{
            ans = Math.min(ans, nums[l]);
            return bs(nums, m+1, h, ans);
        }
    }

    public int findMin(int[] nums) {
        return bs(nums, 0, nums.length - 1, Integer.MAX_VALUE);
    }
}