class Solution {

    int f(int n, int[] nums, int[] dp){
        if(n == 0) return nums[0];
        if(n == -1) return 0;

        int tk, ntk;
        if(dp[n] != -1) return dp[n];
        tk = nums[n] + f(n-2, nums, dp);
        ntk = f(n-1, nums, dp);

        return dp[n] = Math.max(tk, ntk);
    }

    public int rob(int[] nums) {
        int n = nums.length, ans1, ans2, ntk, tk;
        if(n == 1) return nums[0];
        
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        
        int k1 = 0, k2 = 0;
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];

        for(int i = 0; i < n; i++){
            if(i != 0) temp1[k1++] = nums[i];
            if(i != n-1) temp2[k2++] = nums[i];
        }
        ans1 = f(n-2, temp1, dp1);
        ans2 = f(n-2, temp2, dp2);

            
        return Math.max(ans1, ans2);
    }
}