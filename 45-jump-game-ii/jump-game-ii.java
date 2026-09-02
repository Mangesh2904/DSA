class Solution {

    int memo(int n, int[] nums, int[] dp){
        
        if(n >= nums.length - 1) return 0;

        if(dp[n] != 0) return dp[n];
        int min = Integer.MAX_VALUE/2;

        for(int i = 1; i <= nums[n]; i++)
            min = Math.min(min, 1 + memo(n + i, nums, dp));

        return dp[n] = min;
    }

    int tabu(int n, int[] nums, int[] dp){

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
        int n = nums.length, r = 0, l = 0, jum = 0, maxR = 0;
        int[] dp = new int[n+1];

        // return memo(0, nums, dp);
        // return tabu(n, nums, dp);

        while(r < n){
            if(maxR >= n-1) break;

            for(int i = l; i <= r; i++)
                maxR = Math.max(maxR, i + nums[i]);

            l = r + 1;
            r = maxR;
            jum++;
        }

        return jum;
        
    }
}