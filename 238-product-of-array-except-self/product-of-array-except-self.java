class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        ans[n - 1] = 1;
        int a = 1;
  
  
        // int[] prefix = new int[nums.length];
        // prefix[0] = 1;
        // int[] ans = new int[n];




        for(int i = 1, j = n - 2; i < n && j >= 0; i++, j--){
            ans[j] = nums[j + 1] * ans[j + 1];


            // prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        for(int i = 0; i < n; i++){
            ans[i] = a * ans[i];
            a *= nums[i];
        }

        return ans;
    }
}

//  1       2   10  60  180  
// a = 10
//  360*5  360*2
//  2       5   6   3   5   4
//  360*5  360  60  20   4  1