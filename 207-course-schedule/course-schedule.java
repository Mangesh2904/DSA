class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] ind = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();


        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int[] it : prerequisites) adj.get(it[0]).add(it[1]);
        for(int[] it : prerequisites) ind[it[1]]++;
        for(int i = 0; i < numCourses; i++) if(ind[i] == 0) q.offer(i);

        while(!q.isEmpty()){
            int t = q.poll();
            ans.add(t);

            for(int it : adj.get(t)){
                ind[it]--;
                if(ind[it] == 0) q.offer(it);
            }
        }

        if(ans.size() == numCourses) return true;

        return false;

    }
}