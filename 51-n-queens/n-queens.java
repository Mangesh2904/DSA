class Solution {

    void nQueens(int col, int n, char[][] board, List<List<String>> ans, int[] row, int[] uDiag, int[] lDiag){
        
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int r = 0; r < n; r++){
            if(row[r] == 0 && lDiag[r+col] == 0 && uDiag[col-r + n-1] == 0){
                board[r][col] = 'Q';
                row[r] = 1;
                uDiag[n-1 + col-r] = 1;
                lDiag[r+col] = 1;
                nQueens(col+1, n, board, ans, row, uDiag, lDiag);
                board[r][col] = '.';
                row[r] = 0;
                uDiag[n-1 + col-r] = 0;
                lDiag[r+col] = 0;
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        int[] row = new int[n];
        int[] uDiag = new int[2*n - 1];
        int[] lDiag = new int[2*n - 1];
        
        nQueens(0, n, board, ans, row, uDiag, lDiag);

        return ans;

    }
}