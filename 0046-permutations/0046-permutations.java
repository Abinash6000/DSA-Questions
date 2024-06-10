class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> possPerm = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solvePossPerm(nums, possPerm, new ArrayList<>(), used);
        return possPerm;
    }

    private void solvePossPerm(int[] nums, List<List<Integer>> possPerm, List<Integer> currPerm, boolean[] used) {
        if(currPerm.size() == nums.length) {
            possPerm.add(new ArrayList<>(currPerm));
            return;
        }

        for(int i = 0; i<nums.length; i++) {
            if(used[i]) continue;
            currPerm.add(nums[i]); // choose
            used[i] = true;

            solvePossPerm(nums, possPerm, currPerm, used);

            currPerm.remove(currPerm.size()-1); // unchoose
            used[i] = false;
        }
    }
}