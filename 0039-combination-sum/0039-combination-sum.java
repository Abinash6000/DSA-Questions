class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] candidates, int target, int pos, List<Integer> currComb, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(currComb));
            return;
        }
        if(target < 0) {
            return;
        }

        for(int i = pos; i<candidates.length; i++) {
            currComb.add(candidates[i]);
            helper(candidates, target-candidates[i], i, currComb, res);
            currComb.remove(currComb.size()-1);
        }
    }
}