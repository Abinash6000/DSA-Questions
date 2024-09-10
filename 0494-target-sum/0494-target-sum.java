class Solution {
    int memo[][];
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int i : nums) total+=i;
        if((total+target)%2!=0) return 0;
        target = (total+Math.abs(target))/2;
        memo = new int[Math.abs(target)+1][nums.length+1];
        return solve(nums, Math.abs(target), nums.length);
    }
    private int solve(int[] nums, int target, int n) {
        if(n==0)
            return target==0 ? 1 : 0;
        if(memo[target][n]!=0) return memo[target][n];
        if(target>=nums[n-1]) {
            return memo[target][n] = solve(nums, target-nums[n-1], n-1) + solve(nums, target, n-1);
        } else return memo[target][n] = solve(nums, target, n-1);
    }
}