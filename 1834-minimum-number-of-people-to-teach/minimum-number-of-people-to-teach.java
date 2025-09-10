class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> userLangs = new ArrayList<>();
        for (int[] l : languages) {
            Set<Integer> set = new HashSet<>();
            for (int x : l) {
                set.add(x);
            }
            userLangs.add(set);
        }

        Set<Integer> needFix = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1; 
            int v = f[1] - 1;
            Set<Integer> setU = userLangs.get(u);
            Set<Integer> setV = userLangs.get(v);

            boolean share = false;
            for (int lang : setU) {
                if (setV.contains(lang)) {
                    share = true;
                    break;
                }
            }
            if (!share) {
                needFix.add(u);
                needFix.add(v);
            }
        }

        if (needFix.isEmpty()) return 0;

        int ans = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int knows = 0;
            for (int user : needFix) {
                if (userLangs.get(user).contains(lang)) {
                    knows++;
                }
            }
            ans = Math.min(ans, needFix.size() - knows);
        }

        return ans;
    }
}
