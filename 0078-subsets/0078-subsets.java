class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, noOfSubsets = 1<<n;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<noOfSubsets; i++) {
            List<Integer> subs = new ArrayList<>();
            for(int j = 0; j<n; j++) {
                if(((i>>j)&1) == 1) {
                    subs.add(nums[j]);
                }
            }
            res.add(subs);
        }

        return res;
    }
}