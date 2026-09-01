class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, ans = 0, zer = 0, n = nums.length;

        while(r < n){
            if(nums[r] == 0 && zer == k){
                if(nums[l] == 0) zer--;
                l++;
                continue;
            } 

            else if(nums[r] == 0 && zer < k) zer++;

            ans = Math.max(ans, r - l + 1);
            r++;
        }
        
        return ans;
    }
}