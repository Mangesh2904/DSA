class Solution {

    int bs(int[] nums, int l, int h, int t){
                
        // if(l > h) return nums[l] + t - (nums[l] - l - 1); 
        if(l > h) return t + l;

        int m = (l + h) / 2;
        int ans = nums[m] - m - 1;

        if(ans < t) return bs(nums, m+1, h,  t);

        return bs(nums, l, m-1, t);


    }

    public int findKthPositive(int[] arr, int k) {
        return bs(arr, 0, arr.length - 1, k);
    }
}