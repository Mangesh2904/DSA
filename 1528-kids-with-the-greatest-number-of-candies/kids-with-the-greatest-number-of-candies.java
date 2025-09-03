class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> l = new ArrayList<>();
        int m = Arrays.stream(candies).max().getAsInt();
        for(int i : candies){
            if(i + extraCandies < m) l.add(false);
            else l.add(true);
        }

        return l;
    }
}