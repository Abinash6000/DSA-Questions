class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;

        for(int i = 0; i<n; i++) {
            int st = 0, ed = potions.length-1;
            int spell = spells[i];

            while(st <= ed) {
                int mid = st + (ed-st)/2;
                int potion = potions[mid];

                if(isSuccess(success, (long) spell, (long) potion)) {
                    ed = mid-1;
                } else {
                    st = mid+1;
                }
            }

            spells[i] = potions.length-ed-1;
        }

        return spells;
    }

    private boolean isSuccess(long suc , long spell, long potion) {
        return suc <= (spell*potion);
    }
}