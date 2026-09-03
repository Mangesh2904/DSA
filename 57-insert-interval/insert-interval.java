class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int s = newInterval[0];
        int f = newInterval[1];

        int n = intervals.length, i = 0;

        List<int[]> lst = new ArrayList<>(); 

        while(i < n && intervals[i][1] < newInterval[0]){
            int f1 = intervals[i][1];
            int s1 = intervals[i][0];

            lst.add(new int[]{s1, f1});
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            int f1 = intervals[i][1];
            int s1 = intervals[i][0];

            newInterval[0] = Math.min(newInterval[0], s1);
            newInterval[1] = Math.max(newInterval[1], f1);    
            i++;
        }

        lst.add(new int[]{newInterval[0], newInterval[1]});

        while(i < n){
            int f1 = intervals[i][1];
            int s1 = intervals[i][0];

            lst.add(new int[]{s1, f1});
            i++;
        }


        return lst.toArray(new int[lst.size()][]);

     
        
    }
}