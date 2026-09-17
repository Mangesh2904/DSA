class Solution {

    boolean bs(int r, int c, int nums[][], int t){

        if( r >= nums.length || c < 0) return false;

        if(nums[r][c] == t) return true;

        if(t < nums[r][c]) return bs(r, c - 1, nums, t);

        return bs(r + 1, c, nums, t);
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        return bs(0, m - 1, matrix, target);
    }
}