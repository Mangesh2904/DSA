class Solution {

    int memo(int n, int[] nums, int jum, int[] dp){
        
        if(n >= nums.length - 1) return jum;

        if(dp[n] != 0) return dp[n];
        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= nums[n]; i++)
            min = Math.min(min, memo(n + i, nums, jum + 1, dp));

        return dp[n] = min;
    }

    int tabu(int n, int[] nums, int jum, int[] dp){

        dp[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--){
            int min = Integer.MAX_VALUE/2;

            for(int j = 1; j <= nums[i]; j++){

                if(i + j >= n)
                    break;
                
                min = Math.min(min, dp[i + j] + 1);
            
            }
            dp[i] = min;        
        }
        return dp[0];
    }
    
    public int jump(int[] nums) {
        int n = nums.length, r = 0, l = 0, jum = 0;
        int[] dp = new int[n+1];

        // return memo(0, nums, 0, dp);
        return tabu(n, nums, 0, dp);
    }
}