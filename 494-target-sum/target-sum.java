class Solution {

    int recc(int n, int nums[], int tar, int[][] dp){
        if(n == 0){
            if(nums[0] == 0 && tar == 0) return 2;
            if(nums[n] == Math.abs(tar)) return 1;
            return 0;
        }

        int pos = recc(n-1, nums, tar - nums[n], dp); 
        int neg = recc(n-1, nums, tar + nums[n], dp); 

        return pos + neg;
    }

    int memo(int n, int nums[], int tar, int[][] dp){

        if(n == 0){
            if(nums[n] == 0 && tar == 0) return 2;
            if(nums[n] == tar || tar == 0) return 1;
            return 0;
        }

        if(dp[n][tar] != 0) return dp[n][tar];

        int tk = 0;
        int ntk = memo(n - 1, nums, tar, dp);

        if(nums[n] <= tar) tk = memo(n - 1, nums, tar - nums[n], dp);

        return dp[n][tar] = tk + ntk;
    }
    
    int tabulation(int n, int nums[], int tar, int[][] dp){

        if(nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(nums[0] <= tar && nums[0] > 0) dp[0][nums[0]] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= tar; j++){
                int tk = 0;
                int ntk = dp[i - 1][j];

                if(nums[i] <= j) tk = dp[i - 1][j - nums[i]];

                dp[i][j] = tk + ntk;
            }
        }

        return dp[n - 1][tar];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();

        if(Math.abs(target) > total || (total - Math.abs(target)) % 2 != 0) return 0;

        int n = nums.length;
        int tar = (total - Math.abs(target))/2;
        int[][] dp = new int[n][tar + 1];

        // return recc(n - 1, nums, target, dp);
        // return memo(n - 1, nums,  tar, dp);
        return tabulation(n, nums,  tar, dp);
        
    }
}