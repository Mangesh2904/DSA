class Solution {
    public double myPow(double x, int n) {
        if(n == 0 ) return 1;
        if(n < -1074 && x != 1 && x != -1) return 0;
        
        if(n < 0){
            n = -n;
            x = 1/x;
        }

        double ans = myPow(x , n/2);

        if((n & 1) == 0) return ans * ans;
        else return ans * ans * x;
    }
}