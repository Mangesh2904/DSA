class Solution {

    int memo(int sr, int sc, int n, List<List<Integer>> mat, int[][] dp) {

        if (sr == n - 1)
            return mat.get(sr).get(sc);

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int dn = memo(sr + 1, sc, n, mat, dp);
        int rt = memo(sr + 1, sc + 1, n, mat, dp);

        return dp[sr][sc] = Math.min(dn, rt) + mat.get(sr).get(sc);
    }

    int tabu(int n, List<List<Integer>> mat, int[][] dp) {

        for (int i = 0; i < mat.get(n - 1).size(); i++)
            dp[n - 1][i] = mat.get(n - 1).get(i);

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < mat.get(i).size(); j++){
                int d = dp[i + 1][j];
                int rt = dp[i + 1][j + 1];

                dp[i][j] = mat.get(i).get(j) + Math.min(d, rt);
            }
        }

        return dp[0][0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int dp[][] = new int[n + 1][n + 1];

        // return memo(0, 0, n, triangle, dp);
        return tabu(n, triangle, dp);

    }
}