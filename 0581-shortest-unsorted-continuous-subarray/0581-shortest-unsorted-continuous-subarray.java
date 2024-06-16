class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);

        int st = -1, ed = -1;
        int n = nums.length;

        for(int i = 0; i<n; i++) {
            if(nums[i] != copyNums[i]) {
                if(st == -1) {
                    st = i;
                    ed = i;
                } else {
                    ed = i;
                }
            }
        }

        int ans = ed-st+1;
        return ans == 1 ? 0 : ans;
    }
}