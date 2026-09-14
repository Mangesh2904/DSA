class Solution {

    int memo(int n, int[] cost, int[] dp){
        if(n < 0) return 0;

        if(dp[n] != 0) return dp[n];

        int stp1 = memo(n - 1, cost, dp);

        int stp2 = memo(n - 2, cost, dp);

        return dp[n] = Math.min(stp1, stp2) + cost[n];
    }

    int tabu(int n, int[] cost, int[] dp){
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++){
            int stp1 = dp[i - 1];
            int stp2 = dp[i - 2];

            dp[i] = Math.min(stp1, stp2) + cost[i];
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    int space(int n, int[] cost){
        int p0 = cost[0];
        int p1 = cost[1];

        for(int i = 2; i < n; i++){
            int curr = cost[i] + Math.min(p0, p1);

            p0 = p1;
            p1 = curr;
        }

        return Math.min(p0, p1);
    }
    
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int dp[] = new int[n + 1];

        // int a1 = memo(n - 1, cost, dp);

        // int a2 = memo(n - 2, cost, dp);

        // return Math.min(a1, a2);

        // return tabu(n, cost, dp);
        return space(n, cost);

    }
}