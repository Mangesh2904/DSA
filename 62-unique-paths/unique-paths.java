class Solution {

    // memoization
    int grid(int m, int n, int[][]dp){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        return grid(m-1, n, dp) + grid(m, n-1, dp);
    }

    int tabulation(int m, int n, int[][] dp){
        dp[0][0]= 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int up = 0, dn = 0;
                if(i == 0 && j == 0) continue;
                if(i > 0) up = dp[i-1][j];
                if(j > 0) dn = dp[i][j-1];

                dp[i][j] = up + dn;
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] i : dp) Arrays.fill(i, -1);
        
        return tabulation(m, n, dp);
        // return grid(m-1, n-1, dp);
    }
}