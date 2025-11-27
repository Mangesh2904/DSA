class Solution {

    int lb(int[] arr, int l, int h, int t, int ans){
        if(l > h) return ans;

        int m = (l + h)/2;

        if(arr[m] >= t){
            ans = Math.min(ans, m);
            return lb(arr, l, m-1, t, ans);
        }

        return lb(arr, m+1, h, t, ans);
    }

    int ub(int[] arr, int l, int h, int t, int ans){
        if(l > h) return ans;

        int m = (l + h)/2;

        if(arr[m] > t){
            ans = Math.min(ans, m);
            return ub(arr, l, m-1, t, ans);
        }

        return ub(arr, m+1, h, t, ans);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int l = lb(nums, 0, nums.length - 1, target, nums.length);
        int u = ub(nums, 0, nums.length - 1, target, nums.length);

        if( l == nums.length || nums[l] != target) return ans;

        ans[0] = l;
        ans[1] = u - 1;

        return ans;
    }
}