class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, dp[] = new int[n], hash[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(hash, -1);
        Arrays.sort(nums);

        int maxi = 0;

        for(int i = 1; i<n; i++) {
            for(int j = 0; j<i; j++) {

                if(nums[i]%nums[j] == 0 && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
            }

            if(dp[maxi] < dp[i])
                maxi = i;
        }

        List<Integer> res = new ArrayList<>();
        while(hash[maxi] != -1) {
            res.add(nums[maxi]);
            maxi = hash[maxi];
        }
        res.add(nums[maxi]);
        Collections.reverse(res);

        return res;
    }
}