class Solution {

    boolean isB(int src, List<List<Integer>> adj, int[] vis){

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        vis[src] = 1;

        while(!q.isEmpty()){
            int t = q.poll();

            for(int it : adj.get(t)){
                if(vis[it] == 0){
                    q.offer(it);
                    vis[it] = (vis[t] == 1 ? 2 : 1);
                }
                else if(vis[it] == vis[t]) return false;
            }
        }

        return true;
    }


    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        int[] vis = new int[graph.length];

        for(int i = 0; i < graph.length; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < graph.length; i++){
            for(int j : graph[i]) adj.get(i).add(j);
        }

        for(int i = 0; i < graph.length; i++){

            if(vis[i] == 0)
                if(isB(i, adj, vis) == false) return false;
        }
        return true;

    }
}