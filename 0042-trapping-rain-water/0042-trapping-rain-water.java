class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n], sufMax = new int[n];

        for(int i = 1; i<n; i++) {
            preMax[i] = Math.max(preMax[i-1], height[i-1]);
            sufMax[n-i-1] = Math.max(sufMax[n-i], height[n-i]); 
        }

        int vol = 0;
        for(int i = 0; i<n; i++) {
            int curVol = Math.min(preMax[i], sufMax[i]) - height[i];
            if(curVol > 0) vol += curVol;
        }

        return vol;
    }
}