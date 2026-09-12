class Solution {

    int memo(int idx, int flag, int[] prices, int n, int[][] dp) {
        if (idx == n - 1) {
            if (flag == 1)
                return prices[idx];
            return 0;
        }

        if (dp[idx][flag] != 0)
            return dp[idx][flag];

        if (flag == 0) {
            int buy = -prices[idx] + memo(idx + 1, 1, prices, n, dp);
            int ntBuy = memo(idx + 1, 0, prices, n, dp);

            return dp[idx][flag] = Math.max(buy, ntBuy);
        }

        int sell = prices[idx] + memo(idx + 1, 0, prices, n, dp);
        int ntSell = memo(idx + 1, 1, prices, n, dp);

        return dp[idx][flag] = Math.max(sell, ntSell);
    }

    int tabu(int[] prices, int n, int[][] dp) {

        dp[n - 1][1] = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {

                if (j == 0) {
                    int buy = -prices[i] + dp[i + 1][j + 1];
                    int ntBuy = dp[i + 1][j];

                    dp[i][j] = Math.max(buy, ntBuy);

                } else {
                    int sell = prices[i] + dp[i + 1][j - 1];
                    int ntSell = dp[i + 1][j];

                    dp[i][j] = Math.max(sell, ntSell);
                }
            }
        }

        return dp[0][0];
    }

    int space(int[] prices, int n) {
        int[] next = new int[2];

        next[1] = prices[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int curr[] = new int[2];

            for (int j = 0; j < 2; j++) {

                if (j == 0) {
                    int by = -prices[i] + next[1];
                    int ntBy = next[0];

                    curr[j] = Math.max(by, ntBy);

                } else {
                    
                    int sl = prices[i] + next[0];
                    int ntSl = next[1];

                    curr[j] = Math.max(sl, ntSl);
                }
            }

            next = curr;
        }

        return next[0];
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int flag = 0;

        int[][] dp = new int[n + 1][2];

        // return memo(0, 0, prices, n, dp);
        // return tabu(prices, n, dp);
        return space(prices, n);

    }
}