class Solution {

// memoization

    // int f(int n, int[] nums, int[] dp){
    //     if(n == 0) return nums[n];
    //     if(n == -1) return 0;

    //     int pk, npk;
    //     if(dp[n] != -1) return dp[n];
    //     pk = nums[n] + f(n-2, nums, dp);
    //     npk =  f(n-1, nums, dp);

    //     return dp[n] = Math.max(pk, npk);
    // }
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);

    //     return f(n - 1, nums, dp);
        
    // }


// tabulation

    public int rob(int[] nums) {
        int n = nums.length, pk, npk;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        if(n == 1) return nums[0];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++){
            pk = nums[i] + dp[i - 2];
            npk = dp[i-1];

            dp[i] = Math.max(pk, npk);
        }

        return dp[n-1];
    }
}