class Solution {
    public int longestConsecutive(int[] nums) {
        int r = 0, ans = 1, n = nums.length;

        if (n == 0)
            return 0;

        HashSet<Integer> st = new HashSet<>();

        for (int i : nums)
            st.add(i);

        if (st.size() == 1)
            return 1;


        for(int it : st){

            if(!st.contains(it - 1)){
                int c = 0;

                while(st.contains(it)){
                    c++;
                    it++;
                }

                ans = Math.max(ans, c);
            }
        }

        return ans;

        
        
// converted while to for  |^|
        // while (r < n) {
        //     int i = nums[r];

        //     if (!st.contains(i - 1)) {
        //         int c = 0;

        //         while (st.contains(i)) {
        //             c++;
        //             i++;
        //         }

        //         ans = Math.max(ans, c);
        //     }

        //     r++;
        // }

    }
}