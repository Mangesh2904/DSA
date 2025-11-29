class Solution {

    int bs(int[] nums, int l, int h){
        if(l >= h) return nums[l];

        int m = (l+h)/2;

        if(nums[m] == nums[m+1]){
            if((m - l) % 2 == 0) return bs(nums, m+2, h);
            else return bs(nums, l, m-1);
        }

        else if(nums[m] == nums[m-1]){
            if((m - l - 1) % 2 == 0) return bs(nums, m+1, h);
            else return bs(nums, l, m-2);
        }

        else return nums[m];
    }


    public int singleNonDuplicate(int[] nums) {
        return bs(nums, 0, nums.length - 1);
    }
}