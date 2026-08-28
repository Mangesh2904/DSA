class Solution {
    int memo(int n, int coins[], int amt, int[][] dp) {

        if (amt == 0)
            return 0;
        if (n == 0) {
            if (amt % coins[0] == 0)
                return amt / coins[0];
            return Integer.MAX_VALUE/2;
        }

        if (dp[n][amt] != -1)
            return dp[n][amt];

        int tk = Integer.MAX_VALUE / 2;
        int ntk = memo(n - 1, coins, amt, dp);

        if (coins[n] <= amt)
            tk = 1 + memo(n, coins, amt - coins[n], dp);

        return dp[n][amt] = Math.min(tk, ntk);

    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // if (n == 1) {
        //     if (amount % coins[0] == 0)
        //         return amount / coins[0];
        //     if (amount % coins[0] != 0)
        //         return -1;

        // }

        int[][] dp = new int[n][amount + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);

        int ans = memo(n - 1, coins, amount, dp);
        return ans >= Integer.MAX_VALUE/2 ? -1 : ans;
    }
}