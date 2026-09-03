class Solution {
    public List<Integer> partitionLabels(String s) {

        int n = s.length(), l = 0, r = 0, mx = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++) mp.put(s.charAt(i), i);

        List<Integer> lst = new ArrayList<>();

        while(r < n){
            mx = Math.max(mx, mp.get(s.charAt(r)));

            if(mx == r){
                lst.add(r - l + 1);
                l = r + 1;
            }

            r++;
        }       

        return lst; 
    }
}