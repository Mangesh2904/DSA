class Solution {
    public int jump(int[] nums) {
        
        int l = 0, r = 0, n = nums.length, j = 0;
        
        while(r < n - 1){
            int f = 0;

            for(int i = l; i <= r; i++){
                f = Math.max(f, i + nums[i]);
            }
            j++;
            l = r+1;
            r = f;
        }
        return j;
    }
}