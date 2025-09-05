class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(arr, arr.length-1, new ArrayList<>(), ans);
        return ans;
    }
    
    private void helper(int[] arr, int i, List<Integer> subset, List<List<Integer>> ans) {
        if(i == -1) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        
        // take or not take
        subset.add(arr[i]);
        helper(arr, i-1, subset, ans);
        subset.remove(subset.size()-1);
        helper(arr, i-1, subset, ans);
    }
}