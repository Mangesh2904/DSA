class Solution {
    public int maxProfit(int[] prices) {
        int p = prices[0], mP = 0;
        for(int i : prices){
            if(i < p)
                p = i;
                
            mP = Math.max(mP, i - p);
        }
        return mP;
    }
}