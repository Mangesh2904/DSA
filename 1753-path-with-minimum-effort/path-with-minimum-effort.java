class Pair {
    int r, c, d;

    Pair(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dis = new int[n][m];

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.d - b.d);

        q.offer(new Pair(0, 0, 0));

        for (int[] i : dis)
            Arrays.fill(i, Integer.MAX_VALUE);

        dis[0][0] = 0;

        int[] dr = { -1, 0, 1, 0 };
        int dc[] = { 0, -1, 0, 1 };

        while (!q.isEmpty()) {
            int r = q.peek().r;
            int c = q.peek().c;
            int d = q.poll().d;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];


                if (nr < n && nr >= 0 && nc < m && nc >= 0) {

                    int currD = Math.abs(heights[nr][nc] - heights[r][c]);
                    int newD = Math.max(d, currD);

                    if(newD < dis[nr][nc]){
                        dis[nr][nc] = newD;
                        q.offer(new Pair(nr, nc, newD));
                    }
                }
            }
        }

        return dis[n-1][m - 1];
    }
}