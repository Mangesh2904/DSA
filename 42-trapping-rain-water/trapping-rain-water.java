class Solution {
    public int[] rightMax(int[] arr){
        int[] rm = new int[arr.length];
        int k = arr[arr.length - 1];
        rm[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0 ; i--){
            if(k > arr[i]) rm[i] = k;

            else{
                k = arr[i];
                rm[i] = -1;
            }
        }
        
        return rm;

    }
    public int[] leftMax(int[] arr){
        int[] lm = new int[arr.length];
        int k = arr[0];
        lm[0] = -1;
        for(int i = 1; i < arr.length; i++){
            if(k > arr[i]) lm[i] = k;

            else{
                k = arr[i];
                lm[i] = -1;
            }
        }
        
        return lm;

    }
    public int trap(int[] height) {
        int[] lm = leftMax(height);
        int[] rm = rightMax(height);
        int res = 0;
        for(int i = 1; i < height.length - 1; i++){
            if(height[i] < lm[i] && height[i] < rm[i]) 
                res += Math.min(lm[i] , rm[i]) - height[i];
        }

        return res;
    }
}