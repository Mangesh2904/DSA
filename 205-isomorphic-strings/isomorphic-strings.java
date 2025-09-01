class Solution {
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> mp = new HashMap<>();
        Set<Character> m = new HashSet<>(); 
        int i = 0;
        while(i < s.length()){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mp.containsKey(c1)) 
            {
                if(mp.get(c1) != c2) return false;
            }
            else{
                if(m.contains(c2)) return false;
            }

             
            mp.put(c1, c2);
            m.add(c2);
            i++;
        }

        return true;

    }
}