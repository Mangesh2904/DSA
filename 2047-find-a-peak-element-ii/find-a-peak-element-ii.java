class Solution {

    int max(int[] arr){
        int mx = 0, n = arr.length;

        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[mx]) mx = i;
        }
        
        return mx;
    }

    int[] bs(int l, int r, int[][] mat){
        int m = (l + r) / 2;

        int mx = max(mat[m]);

        if(mat[m][mx] > mat[m - 1][mx] && mat[m][mx] > mat[m + 1][mx]) 
            return new int[]{m, mx};

        if(mat[m][mx] < mat[m + 1][mx]) return bs(m + 1, r, mat);

        return bs(l, m - 1, mat);
    }
    
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;

        int mx = max(mat[0]);
        if(n == 1 || mat[0][mx] > mat[1][mx]) return new int[]{0, mx};

        mx = max(mat[n - 1]);

        if(mat[n - 1][mx] >  mat[n - 2][mx]) return new int[]{n - 1, mx}; 

        return bs(1, n - 2, mat);
    }
}