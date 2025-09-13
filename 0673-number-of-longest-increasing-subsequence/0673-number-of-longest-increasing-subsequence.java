class Solution {
    public int findNumberOfLIS(int[] nums) {
        return countLis(nums);
    }

    private int countLis(int[] nums) {
        int n = nums.length, dp[] = new int[n], count[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        for(int i = 1; i<n; i++) {
            for(int j = 0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    } else if(dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int res = count[0], max = dp[0];
        for(int i = 1; i<n; i++) {
            if(dp[i] == max) {
                res += count[i];
            } else if(dp[i] > max) {
                max = dp[i];
                res = count[i];
            }
        }
        
        return res;
    }
}