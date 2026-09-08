class Pair {
    int r, c;

    Pair(int r, int c){
        this.r = r;  this.c = c;
    }
}

class Solution {

    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;
        int vis[][] = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        int[] drow = {1, 0, 0, -1};
        int[] dcol = {0, 1, -1, 0};
        int iniC = image[sr][sc];
        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int r = q.peek().r;
            int c = q.poll().c;

            for(int i = 0; i < 4; i++){
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if(nr < m && nc < n && nr >= 0 && nc >= 0 && vis[nr][nc] == 0 && image[nr][nc] == iniC){
                    q.offer(new Pair(nr, nc));
                    vis[nr][nc] = 1;
                    image[nr][nc] = color;
                }
                
            }
        }

        return image;

    }
}