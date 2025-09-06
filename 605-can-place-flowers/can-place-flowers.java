class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;

        int s = flowerbed.length;
        int l = 0 , r = 0;

        for(int i = 0 ; i < s; i++){
            if(flowerbed[i] == 0){
                l = (i == 0) ? 0 : flowerbed[i-1]; 
                r = (i == s-1) ? 0 : flowerbed[i+1]; 
                
                if(l == 0 && r == 0){
                    flowerbed[i] = 1;
                    n--;
                }
           }
            if(n == 0) return true;

        }

        
        return false;
    }
}