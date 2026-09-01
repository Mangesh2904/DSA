class Solution {
    public int totalFruit(int[] nums) {
        int l = 0, r = 0, n = nums.length, ans = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        while(r < n){
            
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);

            if(mp.size() > 2){
                mp.put(nums[l], mp.get(nums[l]) - 1);
                if(mp.get(nums[l]) == 0) mp.remove(nums[l]);
                l++;
            }
            if(mp.size() <= 2) ans = Math.max(ans, r - l + 1);
            r++;

        }
        return ans;
    }
}