class Solution {
    public int reversePairs(int[] nums) {
        return divide(0, nums.length-1, nums);
    }

    private int divide(int s, int e, int[] nums) {
        if(s>=e) return 0;

        int m = s + (e-s)/2;
        int s1 = s, s2 = m+1, e1 = m, e2 = e;
        int count = 0;

        count += divide(s, m, nums);
        count += divide(m+1, e, nums);

        while(s1 <= e1 && s2 <= e2) {
            if((long)nums[s1] > (long)(nums[s2]*2L)) {
                count += (e1-s1+1);
                s2++;
            } else s1++;
        }

        conquer(s, m, e, nums);

        return count;
    }

    private void conquer(int s, int m, int e, int[] nums) {
        int s1 = s, s2 = m+1, e1 = m, e2 = e;
        int x = 0;
        int[] sorted = new int[e-s+1];

        while(s1 <= e1 && s2 <= e2)
            if((long)nums[s1] > (long)nums[s2]) sorted[x++] = nums[s2++];
            else sorted[x++] = nums[s1++];

        while(s1 <= e1) sorted[x++] = nums[s1++];
        while(s2 <= e2) sorted[x++] = nums[s2++];

        for(int i = s, j = 0; i<=e; i++,j++) nums[i] = sorted[j];
    }
}