class Solution {

    int bs(int l, int h, int t, int[] nums){

        int m = (l + h) / 2;

        if(l > h) return -1;

        if(nums[m] == t) return m;

        if(nums[m] <= nums[h]){
            if(t > nums[m] && t <= nums[h]) return bs(m + 1, h, t, nums);
            else return bs(l, m - 1, t, nums);
        }

        else {
            if(t >= nums[l] && t < nums[m]) return bs(l, m - 1, t, nums);
            else return bs(m + 1, h, t, nums);
        }
    }
    
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;

        return bs(l, h, target, nums);
    }
}