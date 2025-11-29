class Solution {

    int bs(int x, int l, int h){
        if(l > h) return h;

        int m = (l+h)/2;

        if(m> x/m) return bs(x, l, m-1);

        else if(m < x/m) return bs(x, m+1, h);

        else return m;
    }

    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x < 4) return 1;

        return bs(x, 1, x/2);
    }
}