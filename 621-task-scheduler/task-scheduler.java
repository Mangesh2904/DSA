class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char c : tasks) freq[c - 'A']++;

        Arrays.sort(freq);

        int mxFrq = freq[25];
        int totalSlt = mxFrq - 1;
        int idleSlots = totalSlt * n;

        for(int i = 24; i >= 0; i--){
            idleSlots -= Math.min(totalSlt, freq[i]);
        }

        if(idleSlots > 0) return tasks.length + idleSlots;
        
        
        return tasks.length;
        
    }
}