class Solution {
    public String reverseVowels(String s) {
        int l = 0, r = s.length()-1;
        StringBuilder ans = new StringBuilder(s);
        List<Character> v = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        while(l < r){
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);

            if(!v.contains(c1)) l++;
            if(!v.contains(c2)) r--;

            if(v.contains(c1) && v.contains(c2)){
                ans.setCharAt(l, c2);
                ans.setCharAt(r, c1);
                l++;
                r--;
            }
        }

        return ans.toString();
    }
}