class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] ind = new int[numCourses];
        int[] ans = new int[numCourses];
        int k = numCourses;

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int[] it : prerequisites) adj.get(it[0]).add(it[1]); 
        for(int[] it : prerequisites) ind[it[1]]++;
        for(int i = 0; i < numCourses; i++) if(ind[i] == 0) q.offer(i);

        while(!q.isEmpty()){
            int t = q.poll();
            ans[--k] = t;

            for(int it : adj.get(t)){
                ind[it]--;
                if(ind[it] == 0) q.offer(it);
            }
        }

        if(k == 0) return ans;

        return new int[0];

    }
}