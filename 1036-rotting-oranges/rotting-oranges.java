class Pair{
    int r,c,t;

    Pair(int r, int c, int t){
        this.r = r; this.c = c; this.t = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int t = 0, fresh = 0, count = 0, ans = 0;
        int r = grid.length, c = grid[0].length;
        int[][] vis = new int[r][c];
        Queue<Pair> q = new LinkedList<>();


        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j] == 1) fresh++;
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().r;
            int col = q.peek().c;
            t = q.peek().t;
            ans = Math.max(ans, t);
            q.remove();

            for(int i = 0; i < 4; i++){
                int new_r = row + drow[i];
                int new_c = col + dcol[i];
                if(new_r >=0 && new_c >= 0 && new_r < r && new_c < c && grid[new_r][new_c] == 1 && vis[new_r][new_c] != 2){
                    vis[new_r][new_c] = 2;
                    q.add(new Pair(new_r, new_c, t+1));
                    count++;
                }
            }
        }

        if(count == fresh) return ans;
        return -1;
    }
}