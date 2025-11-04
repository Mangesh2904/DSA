class Solution {
    public boolean lemonadeChange(int[] bills) {
        int sn = 0, bn = 0;
        for(int i : bills){
            if(i == 5) sn++;
            
            else if(i == 10) {
                if(sn >= 1){
                    bn++;
                    sn--;
                }

                else return false;
            }
            else{
                if(bn >= 1 && sn >= 1){
                    bn--;
                    sn--;
                }

                else if(sn >= 3) sn -= 3;

                else return false;
            }

        }

        return true;
    }
}