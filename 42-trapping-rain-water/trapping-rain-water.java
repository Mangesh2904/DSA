class Solution {

    int[] maxRight(int n, int nums[]){
        int ans[] = new int[n];

        Arrays.fill(ans, -1);

        int mx = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] > mx) mx = nums[i];

            else  ans[i] = mx;
        }   

        return ans;
    }

    int[] maxLeft(int n, int nums[]){
        int ans[] = new int[n];

        Arrays.fill(ans, -1);

        int mx = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] > mx) mx = nums[i];

            else ans[i] = mx;  
        }   

        return ans;
    }
    
    public int trap(int[] height) {

        int n = height.length, ans = 0;

        int[] leftMx = maxLeft(n, height);
        int[] rightMx = maxRight(n, height);

        for(int i = 0; i < n; i++){
            if(leftMx[i] == -1 || rightMx[i] == -1) continue;
            
            ans += Math.min(leftMx[i], rightMx[i]) - height[i];
        }

        return ans;
        
    }
}