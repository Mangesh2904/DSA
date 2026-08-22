class Pair {
    int r, c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length, ans = 0;
        int[][] vis = new int[r][c];
        Queue<Pair> q = new LinkedList<>();

        int[] drow = { -1, 0, 0, 1};
        int[] dcol = { 0, -1, 1, 0};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) q.offer(new Pair(i, j));
                vis[i][j] =  1;
                while (!q.isEmpty()) {
                    int row = q.peek().r;
                    int col = q.poll().c;
                    for (int k = 0; k < 4; k++) {
                        int newR = row + drow[k];
                        int newC = col + dcol[k];

                        if (newR >= 0 && newC >= 0 && newR < r && newC < c && vis[newR][newC] != 1 && grid[newR][newC] == '1') {
                            vis[newR][newC] = 1;
                            q.offer(new Pair(newR, newC));
                        }
                    }

                    if (q.isEmpty())
                        ans++;
                }
            }
        }

        return ans;
    }
}