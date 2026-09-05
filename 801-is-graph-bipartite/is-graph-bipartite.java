class Solution {

    boolean dfs(int src, int[][] graph, int[] vis) {

        for (int it : graph[src]) {
            if (vis[it] == 0) {
                vis[it] = (vis[src] == 1 ? 2 : 1);
                if (dfs(it, graph, vis) == false)
                    return false;
            }

            else if (vis[it] == vis[src])
                return false;
        }

        return true;
    }

    boolean bfs(int src, int[][] graph, int[] vis){
        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        vis[src] = 1;

        while(!q.isEmpty()){
            int t = q.poll();

            for(int it : graph[t]){
                if(vis[it] == 0){
                    vis[it] = (vis[t] == 1 ? 2 : 1);
                    q.offer(it);
                }

                else if(vis[it] == vis[t]) return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int vis[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                if (dfs(i, graph, vis) == false)
                    return false;
                // if (bfs(i, graph, vis) == false)
                //     return false;
            }
        }

        return true;
    }

}