class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> possPerm = new ArrayList<>();
        solvePossPerm(nums, 0, possPerm, new ArrayList<>());
        return possPerm;
    }

    private void solvePossPerm(int[] nums, int idx, List<List<Integer>> possPerm, List<Integer> currPerm) {
        if(currPerm.size() == nums.length) {
            possPerm.add(new ArrayList<>(currPerm));
            return;
        }

        for(int i = idx; i<nums.length; i++) {
            swap(nums, idx, i); // swap
            currPerm.add(nums[idx]); // choose

            solvePossPerm(nums, idx+1, possPerm, currPerm);

            currPerm.remove(currPerm.size()-1); // unchoose
            swap(nums, idx, i); // unswap
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}