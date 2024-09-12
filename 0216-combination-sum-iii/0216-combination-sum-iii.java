class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, 9, res, new ArrayList<>());
        return res;
    }

    private void helper(int k, int target, int ele, List<List<Integer>> res, List<Integer> ss) {
        if(ss.size() == k) {
            if(target == 0) 
                res.add(new ArrayList<>(ss));
            return;
        }
        if(ele == 0)
            return;

        ss.add(ele);
        helper(k, target-ele, ele-1, res, ss);
        ss.remove(ss.size()-1);
        helper(k, target, ele-1, res, ss);
    }
}