class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> st = new HashSet<>();

        for(int i : nums) st.add(i);

        if(st.size() == nums.length) return false;
        return true;

    }
}