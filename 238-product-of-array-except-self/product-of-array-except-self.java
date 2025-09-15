class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[nums.length];
        suffix[n - 1] = 1;
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int[] ans = new int[n];

        for(int i = 1, j = n - 2; i < n && j >= 0; i++, j--){
            suffix[j] = nums[j + 1] * suffix[j + 1];
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        for(int i = 0; i < n; i++){
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }
}

//  1       2   10  60  180  
//  2       5   6   3   5   4
//  360*5  360  60  20   4  1