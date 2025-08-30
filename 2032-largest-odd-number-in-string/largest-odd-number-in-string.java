class Solution {
    public String largestOddNumber(String num) {
        StringBuilder s = new StringBuilder();
        int i = num.length() - 1;
        while(i >= 0){
            char c = num.charAt(i);
            int b = c - '0';
            if((b & 1) != 0)
            {  
                s.append(num.substring(0,i+1));
                break;
            }
            i--;
        }
        return s.toString();
    }
}
