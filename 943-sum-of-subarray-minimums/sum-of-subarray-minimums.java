class Pair {
    int val, idx;

    Pair(int val, int idx){
        this.val = val;

        this.idx = idx;
    }
}

class Solution {


    int[] nse(int n, int[] arr){
        int ans[] = new int[n];

        Arrays.fill(ans, n);

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(arr[n - 1], n - 1));

        for(int i = n - 2; i >= 0;  i--){

            while(!st.isEmpty() && arr[i] < st.peek().val) st.pop();
            
            if(st.isEmpty())  st.push(new Pair(arr[i], i));
            
            else{
        
                int min = st.peek().val;
                int idx = st.peek().idx;

                ans[i] = idx;
                st.push(new Pair(arr[i], i));
            }
        }

        return ans;

    }

    int[] pse(int n, int[] arr){
        int ans[] = new int[n];

        Arrays.fill(ans, -1);

        Stack<Pair> st = new Stack<>();

        st.push(new Pair(arr[0], 0));

        for(int i = 1; i < n;  i++){

            while(!st.isEmpty() && arr[i] <= st.peek().val) st.pop();
            
            if(st.isEmpty())  st.push(new Pair(arr[i], i));

            else{
            
                int min = st.peek().val;
                int idx = st.peek().idx;

                ans[i] = idx;
                st.push(new Pair(arr[i], i));
            }
        }

        return ans;

    }
    
    public int sumSubarrayMins(int[] arr) {

        int mod = (int)(1e9 + 7);

        int n = arr.length;
        long ans = 0;

        int ls[] = pse(n, arr);

        int rs[] = nse(n, arr);

        for(int i = 0; i < n; i++){
            int pvArr = i - ls[i];
            int nxArr = rs[i] - i;

            long  contri = (pvArr * nxArr);

            ans = (ans + (contri * arr[i])) % mod ;

        }

        return (int)ans;
        
    }
}