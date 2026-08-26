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

    int tabulation(int n, int m, int[][] arr, int[][] dp){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int u = Integer.MAX_VALUE, l = Integer.MAX_VALUE;

                if( i == 0 && j == 0){
                    dp[i][j] = arr[i][j];
                    continue;
                }  

                if(i > 0) u = arr[i][j] + dp[i-1][j];
                if(j > 0) l = arr[i][j] + dp[i][j-1];
                
                dp[i][j] = Math.min(u, l);
            }
        }

        return dp[n-1][m-1];
    }

    int space(int n, int m, int[][] arr){
        int[] prev = new int[m];

        for(int i = 0; i < n; i++){
            int[] temp = new int[m];

            for(int j = 0; j < m; j++){
                int u = Integer.MAX_VALUE, l = Integer.MAX_VALUE;
                if(i == 0 && j == 0){
                    temp[j] = arr[i][j];
                    continue;
                }

                if(i > 0) u = arr[i][j] + prev[j];
                if(j > 0) l = arr[i][j] + temp[j - 1];

                temp[j] = Math.min(u, l);
            }
            prev = temp;
        }

        return prev[m-1];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int[] i : dp) Arrays.fill(i, -1);

        // return memo(n-1, m-1, grid, dp);
        // return tabulation(n, m, grid, dp);
        return space(n, m, grid);
    }
}