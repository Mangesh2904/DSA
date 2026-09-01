class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n1 = s.length(), n2 = p.length(), r = 0, l = 0;
        List<Integer> ans = new ArrayList<>();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c : p.toCharArray()) freq2[c - 'a']++;

        while(r < n1){
            char c = s.charAt(r);
            char c2 = s.charAt(l);
            freq1[c - 'a']++;

            if(r - l + 1 > n2){
                freq1[c2 - 'a']--;
                l++;
            }

            if(Arrays.equals(freq1, freq2)) ans.add(l);
            r++;
        }
        return ans;
    }
}