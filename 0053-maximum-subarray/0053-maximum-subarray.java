/*
1. Kadane's Algo
2. Brute Force✅
3. 2 Pointer
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = 0;
        for(int i = 0; i<nums.length; i++) {
            currSum += nums[i];
            max = Math.max(max, currSum);
            if(currSum < 0 ) currSum = 0;
        }
        return max;
    }
}