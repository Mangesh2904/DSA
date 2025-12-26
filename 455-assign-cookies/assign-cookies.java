class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0, r = 0, c = 0;

        while(r < s.length && l < g.length){
            if(g[l] <= s[r]){
                c++;
                r++;
                l++;
            }
            else r++;
        }
        return  c;
    }
}