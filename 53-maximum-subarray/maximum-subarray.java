class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length, sum = 0, ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(sum < 0) sum = 0;
            sum += nums[i];
            ans = Math.max(sum, ans);


        }

        return ans;
    }
}