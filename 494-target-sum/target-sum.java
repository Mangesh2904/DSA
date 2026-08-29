class Solution {

    int memo(int n, int nums[], int tar, int[][] dp){
        if(n == 0){
            if(nums[0] == 0 && tar == 0) return 2;
            if(nums[n] == Math.abs(tar)) return 1;
            return 0;
        }

        int pos = memo(n-1, nums, tar - nums[n], dp); 
        int neg = memo(n-1, nums, tar + nums[n], dp); 

        return pos + neg;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][Math.abs(target + 1)];

        return memo(n - 1, nums, target, dp);
        
    }
}