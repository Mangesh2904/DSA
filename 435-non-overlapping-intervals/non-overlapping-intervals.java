class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> b[0] - a[0]);

        int s = intervals[0][0], f = intervals[0][1], c = 0;

        for(int i = 1; i < n; i++){
            int s1 = intervals[i][0];
            int f1 = intervals[i][1];
            if(s1 != s && f1 != f &&f1 <= s){
                s = s1;
                f = f1;
            }
            else c++;
        }
        return c;
    }
}