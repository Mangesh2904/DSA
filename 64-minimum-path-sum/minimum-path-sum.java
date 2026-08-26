class Solution {

    int memo(int n, int m, int[][]arr, int[][] dp){
        if(n == 0 && m == 0) return arr[n][m];

        int u = Integer.MAX_VALUE, l = Integer.MAX_VALUE;
        if(dp[n][m] != -1) return dp[n][m];

        if(n > 0) u = arr[n][m] + memo(n - 1, m, arr, dp);
        if(m > 0) l = arr[n][m] + memo(n, m - 1, arr, dp);

        
        return dp[n][m] = Math.min(u, l);
        
        // if(n < 0 || m < 0) return Integer.MAX_VALUE;
        // return arr[n][m] + Math.min(memo(n - 1, m, arr, dp), memo(n, m - 1, arr, dp));
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int[] i : dp) Arrays.fill(i, -1);
        return memo(n-1, m-1, grid, dp);
    }
}