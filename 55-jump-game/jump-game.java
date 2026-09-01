class Solution {
    public boolean canJump(int[] nums) {
        
        int mx = nums[0], n = nums.length;
        if(n == 1) return true;
        for(int i = 0; i < n; i++){
            if(mx < i) return false;

            mx = Math.max(mx, nums[i] + i);

            if(mx >= n - 1) return true;
        }

        return false;
    }
}