class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int n = people.length;

        Arrays.sort(people);

        HashMap<Integer, Integer> mp = new HashMap<>();

        int ans = 0, l = 0, r = n - 1;

        while(r >= l){

            int pl = people[l];
            int pr = people[r];

            if(pl+ pr <= limit){
                l++;
            }
            
            ans++;
            r--;

        }

        return ans;
        
        
    }
}