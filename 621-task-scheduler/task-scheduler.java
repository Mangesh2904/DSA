class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char c : tasks) freq[c - 'A']++;

        Arrays.sort(freq);

        int mxFrq = freq[25];
            System.out.println(tasks.length);
        int totalSlt = mxFrq - 1;
            System.out.println(totalSlt);
        int idleSlots = totalSlt * n;
            System.out.println(idleSlots);

        for(int i = 24; i >= 0; i--){
            System.out.println(idleSlots+ " " +freq[i]);
            idleSlots -= Math.min(totalSlt, freq[i]);
            System.out.println(idleSlots+ " " +freq[i]);
            if(idleSlots <= 0) return tasks.length;
        }


        return tasks.length + idleSlots;
        
    }
}