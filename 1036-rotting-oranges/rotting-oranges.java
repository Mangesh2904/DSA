class Pair{
    int row;
    int col;
    int tm;

    Pair(int r, int c, int t){
        this.row = r; this.col = c; this.tm = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int[][] vis = new int[r][c];
        Queue<Pair> q = new LinkedList<>();

        int fsh = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j] == 1) fsh++;
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int tm = 0;
        int cnt = 0;

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm, t);
            q.remove();

            for(int i = 0; i < 4; i++){
                int rw = row + drow[i];
                int cl = col + dcol[i];

                if(rw >= 0 && cl >= 0 && rw < r && cl < c && grid[rw][cl] == 1 && vis[rw][cl] != 2){
                    vis[rw][cl] = 2;
                    q.add(new Pair(rw, cl, t + 1));
                    cnt++;
                }
            }
        }


        if(cnt != fsh) return -1;
        return tm;



    }
}