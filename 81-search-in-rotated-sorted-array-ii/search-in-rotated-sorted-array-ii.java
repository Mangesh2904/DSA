class Solution {

    int bs(int[] nums, int l, int h, int t){
        if(l > h) return -1;

        int m = (l+h)/2;
        if(nums[m] == t) return m;
        if(nums[l] == nums[m] && nums[m] == nums[h]) return bs(nums, l+1, h-1, t);
        else if(nums[l] <= nums[m]){
            if(t >= nums[l] && t <= nums[m]) return bs(nums, l, m-1, t);
            else return bs(nums, m+1, h, t);
        }
        else{
            if(t >= nums[m] && t <= nums[h]) return bs(nums, m+1, h, t);
            else return bs(nums, l, m-1, t);
        }
    }

    public boolean search(int[] nums, int target) {
        if(bs(nums, 0, nums.length - 1, target)  != -1) return true;
        else return false;
        // return bs(nums, 0, nums.length - 1, target);
    }
}