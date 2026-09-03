class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int s = newInterval[0];
        int f = newInterval[1];

        int n = intervals.length, i = 0;

        List<int[]> lst = new ArrayList<>(); 

        while(i < n && intervals[i][1] < s){
            int f1 = intervals[i][1];
            int s1 = intervals[i][0];

            lst.add(new int[]{s1, f1});
            i++;
        }

        while(i < n && intervals[i][0] <= f){
            int f1 = intervals[i][1];
            int s1 = intervals[i][0];

            s = Math.min(s, s1);
            f = Math.max(f, f1);    
            i++;
        }

        lst.add(new int[]{s, f});

        while(i < n){
            int f1 = intervals[i][1];
            int s1 = intervals[i][0];

            lst.add(new int[]{s1, f1});
            i++;
        }


        return lst.toArray(new int[lst.size()][]);

     
        
    }
}