class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, c = 0, l = 0, r = 0;

        boolean[] ans = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if(baskets[j] >= fruits[i] && ans[j] == false){
                    c++;
                    ans[j] = true;
                    break;
                }
            }
        }

        return n - c;


    }
}