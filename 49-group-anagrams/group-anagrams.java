class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();

        HashMap<String, List<String>> mp = new HashMap<>();

        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);

            String key = new String(c);

            if(!mp.containsKey(key)) mp.put(key, new ArrayList<>());

            mp.get(key).add(s);

        }

        return new ArrayList<>(mp.values());

    }
}