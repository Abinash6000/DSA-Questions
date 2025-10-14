class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for(int i = k; i<=n-k; i++) {
            if(isInc(nums, i-k, i-1) && isInc(nums, i, i+k-1))
                return true;
        }

        return false;
    }

    private boolean isInc(List<Integer> arr, int st, int ed) {
        for(int i = st+1; i<=ed; i++) {
            if(arr.get(i-1) >= arr.get(i)) return false;
        }

        return true;
    }
}