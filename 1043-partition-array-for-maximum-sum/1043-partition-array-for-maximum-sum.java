class Solution {
    int memo[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        memo = new int[n+1];
        return solve(arr, k, 0);
    }

    private int solve(int[] arr, int k, int i) {
        if(i == arr.length) return 0;
        if(memo[i] != 0) return memo[i];

        int max = -1, sum = -1;
        for(int j = i; j<i+k && j<arr.length; j++) {
            max = Math.max(arr[j], max);
            int noOfEle = j-i+1;
            sum = Math.max(sum, noOfEle*max + solve(arr, k, j+1));
        }

        return memo[i] = sum;
    }
}