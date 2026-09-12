class Solution {

    int memo(int idx, int flag, int cap, int n, int[] prices, int[][][] dp){
        if(cap == 2) return 0;

        if(idx == n) return 0;

        if(dp[idx][flag][cap] != 0) return dp[idx][flag][cap];

        if(flag == 0){
            int by = -prices[idx] + memo(idx + 1, 1, cap, n, prices, dp);
            int ntBy = memo(idx + 1, 0, cap, n, prices, dp);

            return dp[idx][flag][cap] = Math.max(by, ntBy);
        }
        else {
            int sl = prices[idx] + memo(idx + 1, 0, cap + 1, n , prices, dp);
            int ntSl = memo(idx + 1, 1, cap, n , prices, dp);

            return dp[idx][flag][cap] = Math.max(sl, ntSl);
        }
    }

    int tabu(int n, int[] prices, int[][][] dp){
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                dp[n][i][j] = 0;
            }
        }
        
        for(int i = 0; i < n; i++){

            dp[i][0][2] = 0;
            dp[i][1][2] = 0;

        }   

        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    if(j == 0){
                        int by = -prices[i] + dp[i + 1][1][k];
                        int ntBy = dp[i + 1][0][k];

                        dp[i][j][k] = Math.max(by, ntBy);
                        
                    }
                    else {
                        int sl = prices[i] + dp[i + 1][0][k + 1];
                        int ntSl = dp[i + 1][1][k];

                        dp[i][j][k] = Math.max(sl, ntSl);
                        
                    }
                }
            }
        }

        return dp[0][0][0];
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int dp[][][] = new int[n + 1][2][3];
        
        // return memo(0, 0, 0, n, prices, dp);
        return tabu(n, prices, dp);
    }
}