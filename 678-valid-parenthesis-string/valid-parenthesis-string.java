class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0, n = s.length();

        for(char i : s.toCharArray()){

            if(i == '('){
                min ++;
                max++;
            } 
            else if(i == ')'){
                min--;
                max--;
            }
            else{
                min--;
                max++;
            }

            if(min < 0) min = 0;
            if(max < 0) return false;
        }

        return (min == 0);


    }
}