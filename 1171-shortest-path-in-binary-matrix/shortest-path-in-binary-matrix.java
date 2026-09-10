class Pair {
    int r, c, d;

    Pair(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(grid[n-1][n-1] == 1 || grid[0][0] == 1) return -1;
        
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0,0, 1));

        int[][] dis = new int[n][n];
        int[] dr = {-1, 0, 1, 0, 1, -1, 1, -1};
        int[] dc = {0, 1, 0, -1, 1, -1, -1, 1};

        for(int[] i : dis) Arrays.fill(i, Integer.MAX_VALUE/2);

        dis[0][0] = 1;

        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            int d = q.poll().d;

            for(int i = 0; i < 8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < n && nr >= 0 && nc < n && nc >= 0 && grid[nr][nc] == 0){
                    if(dis[nr][nc] > d + 1){
                        dis[nr][nc] = d + 1;
                        q.offer(new Pair(nr, nc, d + 1));
                    }
                }
            }
        }

        if(dis[n - 1][n - 1] == Integer.MAX_VALUE/2) return -1;
        return dis[n-1][n-1];
    }
}