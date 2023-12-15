class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 1, currMin = 1;
        int res = nums[0];

        for(int n : nums) {

            int tmp = currMax * n;
            currMax = Math.max(tmp, Math.max(n*currMin, n));
            currMin = Math.min(tmp, Math.min(n*currMin, n));
            res = Math.max(res, currMax);
        
            if(n == 0) {
                currMax = 1; currMin = 1;
                continue;
            }
        }

        return res;
    }
}