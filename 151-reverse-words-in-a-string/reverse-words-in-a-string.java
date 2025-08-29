class Solution {
    public String reverseWords(String s) {
        List<String> l = Arrays.asList(s.split(" "));

        Collections.reverse(l);

        String ans = String.join(" ", l);
        ans = ans.trim().replaceAll("\\s+", " ");

        return ans;
    }
}