class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++) sum+= nums[i];
        boolean prev[] = new boolean[sum/2+1];
        boolean curr[] = new boolean[sum/2+1];
        if(sum%2 != 0) return false;
        sum = sum/2;

        for(int j = 0; j<=sum; j++) prev[j] = (nums[0] == j ? true : false);

        for(int i = 1; i<nums.length; i++) {
            for(int j = 1; j<=sum; j++) {
                if(nums[i] <= j) {
                    curr[j] = prev[j-nums[i]] || prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr.clone();
        }

        return curr[sum];
    }

    // private boolean helper(int nums[], int i, int sum, Boolean memo[][]) {
    //     if(sum == 0) return true;
    //     if(i == nums.length) return false;
    //     if(memo[i][sum] != null) return memo[i][sum];

    //     if(nums[i] <= sum) {
    //         // two choices
    //         return memo[i][sum] = (
    //             helper(nums, i+1, sum-nums[i], memo)
    //             || helper(nums, i+1, sum, memo));
    //     } else {
    //         return memo[i][sum] = helper(nums, i+1, sum, memo);
    //     }
    // }
}