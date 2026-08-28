class Solution {
    int memo(int n, int coins[], int amt, int[][] dp) {

        if (amt == 0)
            return 0;
        if (n == 0) {
            if (amt % coins[0] == 0)
                return amt / coins[0];
            return Integer.MAX_VALUE / 2;
        }

        if (dp[n][amt] != Integer.MAX_VALUE/2)
            return dp[n][amt];

        int tk = Integer.MAX_VALUE / 2;
        int ntk = memo(n - 1, coins, amt, dp);

        if (coins[n] <= amt)
            tk = 1 + memo(n, coins, amt - coins[n], dp);

        return dp[n][amt] = Math.min(tk, ntk);

    }

    int tabulation(int n, int coins[], int amt, int[][] dp){
        for(int i = 0; i <= amt; i++) 
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= amt; j++){
                int ntk = dp[i - 1][j];

                int tk = Integer.MAX_VALUE/2;

                if(coins[i] <= j) tk = 1 + dp[i][j - coins[i]];

                dp[i][j] = Math.min(tk, ntk);
            }
        }

        return dp[n - 1][amt];

    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for (int i[] : dp)
            Arrays.fill(i, Integer.MAX_VALUE/2);

        // int ans = memo(n - 1, coins, amount, dp);
        int ans = tabulation(n, coins, amount, dp);
        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}