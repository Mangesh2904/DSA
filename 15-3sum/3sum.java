class Solution {

    List<List<Integer>> sum3(int[] nums, int n){

        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);

        int j, k;

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            j = i + 1;
            k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < 0) j++;

                else if(sum > 0) k--;

                else{
                    List<Integer> list = new ArrayList<>();
                    
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);

                    ans.add(list);

                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> st = new HashSet<>();


        int n = nums.length;

        for(int i = 0; i < n - 1; i++){
            HashSet<Integer> mp = new HashSet<>();

            for(int j = i + 1; j < n; j++){
                int third = -(nums[i] + nums[j]);

                if(mp.contains(third)){
                    List<Integer> ls = new ArrayList<>();

                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(third);
                    
                    Collections.sort(ls);
                    
                    st.add(ls);
                }

                mp.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> ls : st) ans.add(ls);

        // return ans;


        return sum3(nums, n);

    }
}