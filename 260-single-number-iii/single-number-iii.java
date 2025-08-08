class Solution {
    public int xor(int[] list){
        int ans = 0;
        for(int i : list){
            ans = ans ^ i;
        }
        return ans;
    }
    public int[] singleNumber(int[] nums) {
        int ans = xor(nums);
        int setBit = ans ^ (ans & (ans-1));
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i : nums){
            if((setBit & i) == 0) l1.add(i);
            else l2.add(i);
        }
        int[] a = new int[2];
        a[0] = xor(l1.stream().mapToInt(Integer::intValue).toArray());
        a[1] = xor(l2.stream().mapToInt(Integer::intValue).toArray());
        return a;
    }
}