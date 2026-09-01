class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, c = 0, l = 0, r = 0;


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if(baskets[j] >= fruits[i]){
                    c++;
                    baskets[j] = -1;
                    break;
                }
            }
        }

        return n - c;


    }
}