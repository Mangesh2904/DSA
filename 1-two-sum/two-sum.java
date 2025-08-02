class Solution {
    public int[] twoSum(int[] nums, int target) {
        int r = 0;
        HashMap<Integer, Integer> m = new HashMap<>(); 
        int[] a = new int[2];
        while(r < nums.length){
            if(m.containsKey(target - nums[r])){
                a[0] = r;
                a[1] = m.get(target - nums[r]);
                break;
            }
            m.put(nums[r], r);
            r++;
        }
        return a;
    }
}