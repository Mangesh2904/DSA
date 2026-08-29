class Solution {

    int memo(int n, int amt, int coins[], int[][] dp){

        if(n == 0){
            if(amt == coins[0] || amt % coins[0]== 0)  return 1;
            return 0;
        }

        if(dp[n][amt] != 0) return dp[n][amt];

        int ntk = memo(n - 1, amt, coins, dp); 

        int tk = 0;
        if(coins[n] <= amt) tk = memo(n, amt - coins[n], coins, dp);

        return dp[n][amt] = tk + ntk;
    }

    int tabulation(int n, int amt, int coins[], int[][] dp){
        
        for(int i = 0; i <= amt; i++) if(i % coins[0]== 0) dp[0][i] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= amt; j++){

                int tk = 0; 
                int ntk = dp[i - 1][j];

                if(coins[i] <= j) tk = dp[i][j - coins[i]];

                dp[i][j] = tk + ntk;
            }
        }

        return dp[n-1][amt];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // return memo(n - 1, amount, coins, dp);
        return tabulation(n, amount, coins, dp);
    }
}