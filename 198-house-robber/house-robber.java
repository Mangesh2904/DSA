class Solution {
    int f(int n, int[] nums, int[] dp){
        if(n == 0) return nums[n];
        if(n == -1) return 0;

        int pk, npk;
        if(dp[n] != -1) return dp[n];
        pk = nums[n] + f(n-2, nums, dp);
        npk =  f(n-1, nums, dp);

        return dp[n] = Math.max(pk, npk);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(n - 1, nums, dp);
        
    }
}