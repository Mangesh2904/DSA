class Solution {
    int memo(int n, int m, List<List<Integer>> arr, int[][] dp, int lst){
        if(n == lst) return arr.get(n).get(m);

        if(dp[n][m] != -1) return dp[n][m];


        int d = arr.get(n).get(m) + memo(n+1, m, arr, dp, lst);
        int diag = arr.get(n).get(m) + memo(n+1, m + 1, arr, dp, lst);

        return dp[n][m] = Math.min(d, diag);
    }

    int tabulation(int n, int m, List<List<Integer>> arr, int[][] dp){
        for(int i = 0; i < arr.get(n-1).size(); i++) dp[n-1][i] = arr.get(n-1).get(i);
        
        for(int i = n-2; i >=0; i--){
            for(int j = 0; j < arr.get(i).size(); j++){
                
                int d , diag;

                d = arr.get(i).get(j) + dp[i + 1][j];
                diag = arr.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(d, diag);
            }

        }
        return dp[0][0];
    }

    int space(int n, int m, List<List<Integer>> arr){
        int[] prev = new int[m];
        for(int i = 0; i < m; i++) prev[i] = arr.get(n-1).get(i);     
       
        for(int i = n-2; i >= 0; i--){
            int[] curr = new int[m];
            for(int j = 0; j < arr.get(i).size(); j++){

                int d = arr.get(i).get(j) + prev[j];
                int diag = arr.get(i).get(j) + prev[j+1];

                curr[j] = Math.min(d, diag); 
            }
            prev = curr;
        }

        return prev[0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), m = triangle.get(n-1).size();
        if(n == 1 && m == 1) return triangle.get(0).get(0);
        int[][] dp = new int[n][m];
        for(int[] i : dp) Arrays.fill(i, -1);

        // return memo(0, 0, triangle, dp, n-1);
        // return tabulation(n, m, triangle, dp);
        return space(n, m, triangle);
    }
}