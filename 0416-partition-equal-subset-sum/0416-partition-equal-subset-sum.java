class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++) sum += nums[i];

        if(sum %2 != 0) return false;
        sum = sum/2;

        return canPart(nums, sum, 0);
    }

    private boolean canPart(int[] nums, int sum, int i) {
        if(i == nums.length)
            return false;

        if(sum == 0)
            return true;

        boolean res = false;
        if(sum - nums[i] >= 0)
            res = canPart(nums, sum-nums[i], i+1);
        res |= canPart(nums, sum, i+1);

        return res;
    }
}