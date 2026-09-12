class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], mP = 0;

        for(int i : prices){
            min = Math.min(min, i);

            mP = Math.max(mP, i - min);
        }

        return mP;
    }
}