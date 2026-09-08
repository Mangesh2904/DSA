class Solution {

    void dfs(int m, int n, int sr, int sc, char[][] mat, int[][] vis) {
        vis[sr][sc] = 1;
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, -1, 0, 1 };

        for (int i = 0; i < 4; i++) {
            int r = sr + dr[i];
            int c = sc + dc[i];

            if (r < m && r >= 0 && c < n && c >= 0 && vis[r][c] == 0 && mat[r][c] != 'X') {
                dfs(m, n, r, c, mat, vis);
            }
        }

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int vis[][] = new int[m][n];

        for (int i = 0; i < n; i++)
            if (board[0][i] == 'O' && vis[0][i] == 0)
                dfs(m, n, 0, i, board, vis);

        for (int i = 0; i < n; i++)
            if (board[m - 1][i] == 'O' && vis[m - 1][i] == 0)
                dfs(m, n, m - 1, i, board, vis);

        for (int i = 0; i < m; i++)
            if (board[i][0] == 'O' && vis[i][0] == 0)
                dfs(m, n, i, 0, board, vis);

        for (int i = 0; i < m; i++)
            if (board[i][n - 1] == 'O' && vis[i][n - 1] == 0)
                dfs(m, n, i, n - 1, board, vis);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }
}