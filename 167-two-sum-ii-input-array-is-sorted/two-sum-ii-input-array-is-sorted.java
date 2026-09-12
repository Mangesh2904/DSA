class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        int[] ans = new int[2];

        while(l < r){
            int lf = numbers[l];
            int rt = numbers[r];
            
            if(lf + rt > target) r--;

            else if(lf + rt < target) l++;

            else break;
        }

        return new int[]{l + 1, r + 1};
    }
}