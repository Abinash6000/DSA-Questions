class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length, suffArr[] = new int[n];
        int max = -2000;

        for(int i = n-1; i>=0; i--) {
            if(i+k < n) {
                suffArr[i] = energy[i] + suffArr[i+k];
            } else 
                suffArr[i] = energy[i];
            max = Math.max(max, suffArr[i]);
        }

        return max;
    }
}