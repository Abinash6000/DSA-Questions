class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combs = new ArrayList<>();
        uniqueComb(candidates, target, combs, new ArrayList<>(), 0);
        return combs;
    }

    private void uniqueComb(int[] arr, int target, List<List<Integer>> combs, List<Integer> comb, int idx) {
        if(target == 0) {
            combs.add(new ArrayList(comb));
            return;
        }
        if(idx == arr.length) return;

        if(arr[idx] <= target) {
            comb.add(arr[idx]);
            uniqueComb(arr, target-arr[idx], combs, comb, idx);
            comb.remove(comb.size()-1);
        }
        uniqueComb(arr, target, combs, comb, idx+1);
    }
}