class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> st = new HashSet<>();


        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            HashSet<Integer> mp = new HashSet<>();

            for(int j = i + 1; j < n; j++){
                int third = -(nums[i] + nums[j]);

                if(mp.contains(third)){
                    List<Integer> ls = new ArrayList<>();

                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(third);
                    
                    Collections.sort(ls);
                    
                    st.add(ls);
                }

                mp.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> ls : st) ans.add(ls);

        return ans;

    }
}