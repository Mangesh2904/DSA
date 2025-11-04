class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int mx = 0;
        for(int i = 0; i < nums.length; i++){
            if(mx < i) return false;
            mx = Math.max(mx, nums[i] + i);
            if(mx >= nums.length - 1) return true;
        }

        return false;
    }
}