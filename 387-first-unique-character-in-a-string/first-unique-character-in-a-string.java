class Solution {
    public int firstUniqChar(String s) {
        // return ans1(s);
        return ans2(s);
    }

    int ans1(String s){
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



    int ans2(String s){
        int n = s.length(), ans = 0;
        int[] freq = new int[26];
        char a = '!';

        for(char c : s.toCharArray()) freq[c - 'a']++;

        for(char c : s.toCharArray()){
            if(freq[c - 'a'] == 1){
                a = c;
                break;
            } 

        }

        return a == '!' ? -1 : s.indexOf(a);
    }

}
    
// 2 for loop laga le freq array bana k