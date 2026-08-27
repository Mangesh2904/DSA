class Solution {
    boolean memo(int n, int[] nums, int sum, boolean[][] dp){
        if(n == 0) return nums[0] == sum;
        if(sum == 0) return true;

        if(dp[n][sum]) return dp[n][sum];
        boolean ntk = memo(n - 1, nums, sum, dp);
        boolean tk = false;
        if(nums[n] < sum) tk = memo(n-1, nums, sum - nums[n], dp);

        return dp[n][sum] = tk || ntk;
    }

    boolean tabulation(int n, int[] nums, int sum, boolean[][] dp){
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(nums[0] < sum) dp[0][nums[0]] = true;

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= sum; j++){

                boolean ntk = dp[i - 1][j];

                boolean tk = false;
                if(nums[i] <= j) tk = dp[i - 1][j - nums[i]];

                dp[i][j] = tk || ntk;
            }
        }

        return dp[n-1][sum];
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum(), n = nums.length;

        if(sum % 2 != 0) return false;
        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        // return memo(n - 1, nums, sum, dp);
        return tabulation(n , nums, sum, dp);

    }
}