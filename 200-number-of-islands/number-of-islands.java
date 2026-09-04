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

        int drow[] = { -1, 0, 0, 1 };
        int dcol[] = { 0, 1, -1, 0 };

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (grid[i][j] == '1' && vis[i][j] != 1) {
                    q.offer(new Pair(i, j));
                    ans++;
                }

                while (!q.isEmpty()) {
                    int R = q.peek().r;
                    int C = q.poll().c;

                    for (int k = 0; k < 4; k++) {
                        int nR = R + drow[k];
                        int nC = C + dcol[k];

                        if (nR < r && nR >= 0 && nC < c && nC >= 0 && grid[nR][nC] != '0' && vis[nR][nC] != 1) {
                            vis[nR][nC] = 1;
                            q.offer(new Pair(nR, nC));
                        }

                    }
                }

            }
        }

        return ans;
    }
}