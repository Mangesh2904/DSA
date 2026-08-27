class Solution {
    int memo(int r, int c, int[][] arr, int[][] dp) {
        if (c < 0 || c >= arr[0].length)
            return Integer.MAX_VALUE;
        if (r == 0)
            return arr[0][c];

        if(dp[r][c] != -1) return dp[r][c];

        int u = memo(r - 1, c, arr, dp);
        int ld = memo(r - 1, c - 1, arr, dp);
        int rd = memo(r - 1, c + 1, arr, dp);

        return dp[r][c] = arr[r][c] + Math.min(u, Math.min(ld, rd));
    }

    int tabulation(int r, int c, int[][] arr, int[][] dp){
        for(int i = 0; i < c; i++) dp[0][i] = arr[0][i];

        for(int i = 1; i < r; i++){
            for(int j = 0; j < c; j++){
                int u = dp[i - 1][j];

                int ld = Integer.MAX_VALUE;
                int rd = Integer.MAX_VALUE;
                
                if(j > 0) ld = dp[i - 1][j - 1];
                if(j < c - 1) rd = dp[i - 1][j + 1];

                dp[i][j] = arr[i][j] + Math.min(u, Math.min(ld, rd));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++)
            ans = Math.min(ans, dp[r-1][i]);

        return ans;
    }

    int space(int r, int c, int[][] arr){

        int[] prev = new int[c];
        for(int i = 0; i < c; i++) prev[i] = arr[0][i];

        for(int i = 1; i < r; i++){
            int[] curr = new int[c];

            for(int j = 0; j < c; j++){
                int u = prev[j];

                int ld = Integer.MAX_VALUE;
                int rd = Integer.MAX_VALUE;

                if(j > 0) ld = prev[j - 1]; 
                if(j < c - 1) rd = prev[j + 1]; 
                
                curr[j] = arr[i][j] + Math.min(u, Math.min(rd, ld));
            }

            prev = curr;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++)
            ans = Math.min(ans, prev[i]);
        
        return ans;
    }


    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int[][] dp = new int[r][r];
        for (int[] i : dp)
            Arrays.fill(i, -1);

        int ans = Integer.MAX_VALUE;

        // for (int i = 1; i <= r; i++)
        //     ans = Math.min(ans, memo(r - 1, r - i, matrix, dp));
        // return ans;

        // return tabulation(r, r, matrix, dp);

        return space(r, r, matrix);
    }
}