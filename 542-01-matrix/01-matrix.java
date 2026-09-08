class Pair {
    int r, c, pre;

    Pair(int r, int c, int pre){
        this.r = r;
        this.c = c;
        this.pre = pre;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int vis[][] = new int[m][n];
        int[][] dis = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.peek().c;
            int pre = q.poll().pre;

            for(int i = 0; i < 4; i++){
                int nR = r + dr[i];
                int nC = c + dc[i];

                if(nR < m && nR >= 0 && nC < n && nC >= 0 && vis[nR][nC] == 0){
                    int nD = pre + 1;
                    q.offer(new Pair(nR, nC, nD));
                    dis[nR][nC] = nD;
                    vis[nR][nC] = 1;
                }
                
            }

        }

        return dis;
    }
}