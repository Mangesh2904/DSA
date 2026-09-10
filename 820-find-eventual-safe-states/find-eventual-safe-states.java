class Solution {

    boolean dfs(int src, int[][] adj, int[] vis, int pvis[], int[] check) {

        vis[src] = 1;
        pvis[src] = 1;

        for (int i : adj[src]) {
            if (vis[i] == 0) {

                if (dfs(i, adj, vis, pvis, check))
                    return true;

            }

            else if (pvis[i] == 1)
                return true;
        }

        check[src] = 1;
        pvis[src] = 0;
        return false;
    }

    List<Integer> bfs(int n, int[][] adj){
        // revere the ind ie. iutdegree is ind
        int ind[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> revAdj = new ArrayList<>();

        for(int i = 0; i < n; i++) revAdj.add(new ArrayList<>());

        for(int i = 0; i < n; i++){
            ind[i] = adj[i].length;

            for(int it : adj[i])
                revAdj.get(it).add(i);
        }

        for(int i = 0; i < n; i++) if(ind[i] == 0) q.offer(i);

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int it : revAdj.get(node)){
                ind[it]--;
                if(ind[it] == 0) q.offer(it);
            }
        }


        Collections.sort(ans);

        return ans;
    }


    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] check = new int[n];
        int[] vis = new int[n];
        int[] pvis = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] != 1)
                dfs(i, graph, vis, pvis, check);

        }

        for (int i = 0; i < n; i++) {
            if (check[i] == 1)
                ans.add(i);
        }

        // return ans;

        return bfs(n, graph);
    }
}