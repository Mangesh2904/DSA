class Pair {
    int stp, nd, d;

    Pair(int stp, int nd, int d){
        this.stp = stp;
        this.nd = nd;
        this.d = d;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int it[] : flights){
            int from = it[0];
            int to = it[1];
            int cost = it[2];

            adj.get(from).add(new int[]{to, cost});
        }

        Queue<Pair> q = new LinkedList<>();

        int dis[] = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);

        q.offer(new Pair(0, src, 0));

        while(!q.isEmpty()){
            int stp = q.peek().stp;
            int nd = q.peek().nd;
            int d = q.poll().d;


            if(stp == k + 1) break;

            for(int it[] : adj.get(nd)){
                int dest = it[0];
                int cost = it[1];

                if(dis[dest] > d + cost){
                    dis[dest] = d + cost;
                    q.offer(new Pair(stp + 1, dest, dis[dest]));  
                }
            }

        }

        if(dis[dst] == Integer.MAX_VALUE) return -1;
        return dis[dst];
        
    }
}