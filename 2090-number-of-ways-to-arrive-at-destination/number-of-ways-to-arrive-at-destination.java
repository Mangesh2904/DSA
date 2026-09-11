class Pair {
    int src;
    long d;

    Pair(int src, long d){
        this.src = src;
        this.d = d;
    }
}

class Solution {

    // int MOD = 10e + 7;
    public int countPaths(int n, int[][] roads) {
        
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));

        long[] dis = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dis, Long.MAX_VALUE);

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i[] : roads){
            int n1 = i[0];
            int n2 = i[1];
            int d = i[2];

            adj.get(n1).add(new int[]{n2, d});
            adj.get(n2).add(new int[]{n1, d});
            
        }
        
        dis[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));

        while(!pq.isEmpty()){
            int nd = pq.peek().src;
            long d = pq.poll().d;

            if(d > dis[nd]) continue;

            for(int[] it : adj.get(nd)){
                int des = it[0];
                long newD = it[1];

                if(dis[des] > newD + d){
                    dis[des] = (newD + d);
                    ways[des] = ways[nd] ;
                    pq.offer(new Pair(des, dis[des]));
                }
                else if(dis[des] == newD + d) ways[des] = (ways[des] + ways[nd]) % 1000000007;
            }
        }

        return ways[n - 1];
        
    }
}