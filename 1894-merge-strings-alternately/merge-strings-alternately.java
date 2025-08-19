class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = 0, l2 = 0;
        StringBuilder s = new StringBuilder();
        while(l1 < word1.length() && l2 < word2.length()){
            s.append(word1.charAt(l1++));
            s.append(word2.charAt(l2++));
        }

        while(l1 < word1.length()) s.append(word1.charAt(l1++));
        while(l2 < word2.length()) s.append(word2.charAt(l2++));

        String ans = s.toString();
        return ans;
    }
}