class Solution {

    int recc(int n, int[] nums, int tar){

        if(n == 0){
            if(nums[n] == 0 && tar == 0) return 2;
            if(nums[n] == Math.abs(tar)) return 1;

            return 0;
        }


        int neg = recc(n - 1, nums, tar + nums[n]);

        int pos = recc(n - 1, nums, tar - nums[n]);

        return pos + neg;
    }

    int memo(int n, int[] nums, int tar, int[][] dp){

        if(n == 0){
            if(nums[n] == 0 && tar == 0) return 2;
            if(nums[n] == Math.abs(tar) || tar == 0) return 1;
            
            return 0;
        }

        int tk = 0;
        if(nums[n] <= tar)
            tk = memo(n - 1, nums, tar - nums[n], dp);

        int ntk = memo(n - 1, nums, tar, dp);

        return tk + ntk;
    }
    
    int tabu(int n, int[] nums, int tar, int[][] dp){

        for(int i = 0; i < n; i++) dp[i][0] = 1;

        if(nums[0] == 0) dp[0][0] = 2;
        else if(nums[0] <= tar) dp[0][nums[0]] = 1;

        for(int i = 1; i < n; i ++){

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
        int n = nums.length;

        int total = Arrays.stream(nums).sum();

        if((total - Math.abs(target)) < 0 || (total - Math.abs(target)) % 2 != 0) return 0;

        int tar = (total - Math.abs(target))/ 2;

        int[][]dp = new int[n + 1][tar + 1];

        // return memo(n - 1, nums, target, dp);        
          
        // return recc(n - 1, nums, target, dp);      
        // return memo(n - 1, nums, tar , dp);      
        return tabu(n, nums, tar , dp);      
        
    }
}