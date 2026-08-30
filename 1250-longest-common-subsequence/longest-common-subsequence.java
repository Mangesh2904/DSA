class Solution {
    int lcsMemo(String s, String t, int i, int j, int[][] dp) {

        if (i == 0 || j == 0)
            return 0;

        if (dp[i][j] != 0)
            return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1))
            return dp[i][j] = 1 + lcsMemo(s, t, i - 1, j - 1, dp);

        return 
            dp[i][j] = Math.max(
                lcsMemo(s, t, i - 1, j, dp), lcsMemo(s, t, i, j - 1, dp)
                );
    }

    int tabulation(String s, String t, int i, int j, int[][] dp){

        // for(int l = 0; l <= i; l++) dp[l][0] = 0

        // int id1 = 1, id2 = 1;

        for(int l1 = 1; l1 <= i; l1++){
            for(int l2 = 1; l2 <= j; l2++){

                if(s.charAt(l1 - 1) == t.charAt(l2 - 1)) 
                    dp[l1][l2] = 1 + dp[l1 - 1][l2 - 1];
                else 
                    dp[l1][l2] = Math.max(dp[l1 - 1][l2], dp[l1][l2 - 1]);
            }
        }

        return dp[i][j];  
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();

        int[][] dp = new int[i + 1][j + 1];

        // return lcsMemo(text1, text2, i , j , dp);
        return tabulation(text1, text2, i, j, dp);
    }
}