https://www.youtube.com/watch?v=rSA3t6BDDwg
# Code
```
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combs = new ArrayList<>();
        solveComb(candidates, target, combs, new ArrayList<>(), 0);
        return combs;
    }

    private void solveComb(int[] arr, int target, List<List<Integer>> combs, List<Integer> comb, int idx) {
        if(target == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        if(idx == arr.length) return;

        if(arr[idx] <= target) {
            comb.add(arr[idx]);
            solveComb(arr, target-arr[idx], combs, comb, idx+1);
            comb.remove(comb.size()-1);
        }

        while(idx < arr.length-1 && arr[idx] == arr[idx+1]) {
            idx++;
        }
        solveComb(arr, target, combs, comb, idx+1);
    }
}
```
```
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combs = new ArrayList<>();
        solveComb(candidates, combs, target, new ArrayList<>(), 0);
        return combs;
    }

    private void solveComb(int[] candidates, List<List<Integer>> combs, int target, List<Integer> comb, int idx) {
        if(target == 0) {
            combs.add(new ArrayList(comb));
        }
        if(target < 0) return;

        int prev = -1;
        for(int i = idx; i<candidates.length; i++) {
            if(candidates[i] == prev) continue;
            comb.add(candidates[i]);
            solveComb(candidates, combs, target-candidates[i], comb, i+1);
            comb.remove(comb.size()-1);
            prev = candidates[i];
        }
    }
}
```
