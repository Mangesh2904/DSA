class Solution {

    int bfs(int[][] grid, int[] vis, int ans){

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            if(vis[i] != 1){
                vis[i] = 1;
                q.offer(i);
                ans++;


                while(!q.isEmpty()){
                    int city = q.poll();
                    
                    for(int j = 0; j < grid.length; j++){
                        if(grid[city][j] == 1 && vis[j] != 1){
                            q.offer(j);
                            vis[j] = 1;
                        } 
                    }
                }

            }
        }

        return ans;

    }
    
    public int findCircleNum(int[][] isConnected) {

        int ans = 0;
        int vis[] = new int[isConnected.length];

        return bfs(isConnected, vis, ans);
        
    }
}