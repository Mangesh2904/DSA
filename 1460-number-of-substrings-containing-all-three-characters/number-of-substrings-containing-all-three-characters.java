class Solution {
    public int numberOfSubstrings(String s) {
        int a = -1, b = -1, c = -1, n = s.length(), ans = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a') a = i;
            else if(s.charAt(i) == 'b') b = i;
            else c = i;
            
            
            if(a>=0 && b>=0 && c>=0){

                ans += Math.min(a, Math.min(b, c)) + 1;
            }
        }
        return ans;
    }
}