class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        Integer[][] mm = new Integer[n][3];
        return solve(0, nums, 0, mm);
    }

    private int solve(int i, int[] nums, int r, Integer[][] mm) {
        if(i == nums.length) {
            if(r == 0)
                return 0;
            return -1000000;
        }
        if(mm[i][r] != null) return mm[i][r];

        int op1 = nums[i] + solve(i+1, nums, (r + nums[i]) % 3, mm);
        int op2 = solve(i+1, nums, r, mm);

        return mm[i][r] = Math.max(op1, op2);
    }
}