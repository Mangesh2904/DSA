class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> mp = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        int n = nums2.length;

        st.push(nums2[n - 1]);

        mp.put(nums2[n - 1], -1);
        n--;

        while(n >= 0){

            int v = nums2[n];

            if(st.isEmpty()){
                
                mp.put(v, -1);

            } 

            else if(v < st.peek()){
                
                mp.put(v, st.peek());
                
            }

            else{

                while(!st.isEmpty() && v >= st.peek()) st.pop();

                if(st.isEmpty()) mp.put(v, -1);

                else mp.put(v, st.peek());

            }
            st.push(v);
            n--;
        }

        int n2 = nums1.length;

        int ans[] = new int[n2];

        for(int i = 0; i < n2; i++){
            ans[i] = mp.get(nums1[i]);
        }

        return ans;
        
    }
}