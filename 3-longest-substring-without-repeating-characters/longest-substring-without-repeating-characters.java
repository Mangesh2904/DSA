class Solution {
    // public int lengthOfLongestSubstring(String s) {
        // int l =0, r = 0, ml = 0;
        // HashMap<Character,Integer> mpp = new HashMap<>();
        // while(r<s.length()){
        //     char c = s.charAt(r);
        //     if(mpp.containsKey(c) && mpp.get(c)>=l)
        //         l = mpp.get(c)+1;
            
        //     mpp.put(c,r);
        //     ml = Math.max(ml,r-l+1);
        //     r++;
        // }
        // return ml;
    // }
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, m = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        while(r<s.length()){
            char c = s.charAt(r);

            if(mpp.containsKey(c) && mpp.get(c)>=l) l = mpp.get(c) + 1;
            
            mpp.put(c , r);
            m = Math.max(m,r-l+1);
            r++;
        }
        return m;
    }
}