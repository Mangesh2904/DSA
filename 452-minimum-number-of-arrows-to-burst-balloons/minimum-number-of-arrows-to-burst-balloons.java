class Solution {
    public int findMinArrowShots(int[][] points) {
        

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int r = 1, ans = 1, n = points.length;

        int f = points[0][1];

        while(r < n) {
            int s1 = points[r][0];
            int f1 = points[r][1];
            if(s1 > f){
                ans++;
                f = f1;
            }

            r++;
        }

        return ans;

    }
}