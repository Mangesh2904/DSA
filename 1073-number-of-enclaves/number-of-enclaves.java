class Solution {

    void dfs(int m, int n, int sr, int sc, int[][] grid, int[][] vis) {
        vis[sr][sc] = 1;

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if (nr < m && nr >= 0 && nc < n && nc >= 0 && vis[nr][nc] != 1 && grid[nr][nc] == 1)
                dfs(m, n, nr, nc, grid, vis);
        }

    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length, ans = 0;

        int vis[][] = new int[m][n];

        for(int i = 0; i < n; i++)
            if(grid[0][i] == 1 && vis[0][i] == 0) dfs(m, n, 0, i, grid, vis);

        for(int i = 0; i < n; i++)
            if(grid[m - 1][i] == 1 && vis[m - 1][i] == 0) dfs(m, n, m - 1, i, grid, vis);

        for(int i = 0; i < m; i++)
            if(grid[i][0] == 1 && vis[i][0] == 0) dfs(m, n, i, 0, grid, vis);

        for(int i = 0; i < m; i++)
            if(grid[i][n - 1] == 1 && vis[i][n - 1] == 0) dfs(m, n, i, n - 1, grid, vis);


        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(vis[i][j] == 0 && grid[i][j] == 1) ans++;

        return ans;
          

    }
}