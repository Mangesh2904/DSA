class Solution {
    public int firstUniqChar(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        int r = 0;

        while(r < n){
            char c = s.charAt(r);
            char a = s.charAt(ans);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            if(mp.get(a) > 1) ans++;

            r++;
            
        }
        while(ans < n){
            if(mp.get(s.charAt(ans)) == 1) break; 
            ans++;

        } 
        return ans == n ? -1 : ans;
    }
}

// 2 for loop laga le freq array bana k