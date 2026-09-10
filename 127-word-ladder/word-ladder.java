class Pair {
    String s;
    int n;

    Pair(String s, int n) {
        this.s = s;
        this.n = n;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> st = new HashSet<>();

        for (String i : wordList)
            st.add(i);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        if (!st.contains(endWord))
            return 0;

        while (!q.isEmpty()) {
            String s = q.peek().s;
            int n = q.poll().n;

            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                for (char c = 'a'; c <= 'z'; c++) {

                    sb.setCharAt(i, c);

                    if (sb.toString().equals(endWord)) {
                        return n + 1;
                    }

                    if (st.contains(sb.toString())) {
                        q.offer(new Pair(sb.toString(), n + 1));
                        st.remove(sb.toString());
                    }

                }
            }

        }

        return 0;

    }
}