class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new HashSet<>(), new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, HashSet<Integer> hs, List<Integer> perm, List<List<Integer>> res) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i = 0; i<nums.length; i++) {
            if(hs.contains(nums[i])) continue;
            perm.add(nums[i]);
            hs.add(nums[i]);
            helper(nums, hs, perm, res);
            perm.remove(perm.size()-1);
            hs.remove(nums[i]);
        }
    }
}