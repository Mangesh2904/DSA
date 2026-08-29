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

        int tk = 0;
        int ntk = memo(n - 1, nums, tar, dp);

        if(nums[n] <= tar) tk = memo(n - 1, nums, tar - nums[n], dp);

        return tk + ntk;
    }
    
    

    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();

        if(Math.abs(target) > total || (total - Math.abs(target)) % 2 != 0) return 0;

        int n = nums.length;
        int[][] dp = new int[n][Math.abs(target + 1)];

        // return recc(n - 1, nums, target, dp);
        return memo(n - 1, nums,  (total - Math.abs(target))/2, dp);
        
    }
}