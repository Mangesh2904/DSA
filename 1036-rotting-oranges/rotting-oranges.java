class Pair{
    int r,c,t;

    Pair(int r, int c, int t){
        this.r = r; this.c = c; this.t = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int tm = 0, fresh = 0, ans = 0;
        int r = grid.length, c = grid[0].length;
        int[][] vis = new int[r][c];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                
                if(grid[i][j] == 2){
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = 1;
                    
                }

                if(grid[i][j] == 1) fresh++;
            }
        }

        int[] drow = {-1, 0, 0, 1};
        int[] dcol = {0, 1, -1, 0};

        while(!q.isEmpty()){
            int rw = q.peek().r;
            int cl = q.peek().c;
             tm = q.poll().t;
            // t = Math.max(t, tm);

            for(int i = 0; i < 4; i++){

                int nR = rw + drow[i];
                int nC = cl + dcol[i];

                if(nR >= 0 && nR < r && nC >= 0 && nC < c && vis[nR][nC] != 1 && grid[nR][nC] == 1){
                    vis[nR][nC] = 1;
                    q.offer(new Pair(nR, nC, tm + 1));
                    ans++;
                }
            }
        }

        return ans == fresh ? tm : -1;       
        
    }
}