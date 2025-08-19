class Solution {
    public int longestConsecutive(int[] arr) {
        int ans = 0;
        HashSet<Integer> s = new HashSet<>();
        for(int i: arr) s.add(i);
        
        for(int i : s){
            if(!s.contains(i-1)){
                int curr = i, c = 1;
                while(s.contains(curr + 1)){
                    c++;
                    curr++;
                }
                ans = Math.max(ans, c);
            }
        }
        return ans;
        
    }
}