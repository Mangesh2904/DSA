class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        int l = 0, r = 0, n1 = s.length(), n2 = t.length();

        for(char c : t.toCharArray()) freq[c]++;
        
        int c = 0, len = n1, start = -1;

        while(r < n1){
            char ch = s.charAt(r);

            if(freq[ch] > 0) c++;

            freq[ch]--;
            while(c == n2){
                char c1 = s.charAt(l);
                freq[c1]++;
                if(len >= r - l + 1){
                    len = r - l + 1;
                    start = l;
                }

                if(freq[c1] > 0) c--;
                l++;
            }

            r++;
        }

        return start == -1 ? "" : s.substring(start, start + len);
    }
}