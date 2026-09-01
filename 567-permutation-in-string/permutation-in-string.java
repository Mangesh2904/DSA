class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0, r = 0, n1 = s1.length(), n2 = s2.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char c : s1.toCharArray()) freq1[c - 'a']++;

        while(r < n2){
            char c = s2.charAt(r);
            char c1 = s2.charAt(l);

            freq2[c - 'a']++;

            if(r - l + 1 > n1){
                freq2[c1 - 'a']--;
                l++;
            }

            if(Arrays.equals(freq1, freq2)) return true;
            r++;
        }

        return false;
    }
}