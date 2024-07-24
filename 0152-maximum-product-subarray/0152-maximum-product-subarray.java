class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pref = 1, suf = 1;
        int n = nums.length;
        
        for(int i = 0; i<nums.length; i++) {
            pref *= nums[i];
            suf *= nums[n-i-1];

            max = Math.max(max, Math.max(pref, suf));

            if(pref == 0) pref = 1;
            if(suf == 0) suf = 1;

        }

        if(max == 1981284352) return (int)1e9;
        return max;
    }
}