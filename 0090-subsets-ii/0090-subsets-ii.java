class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        HashSet<List<Integer>> ans = new HashSet<>();
        Arrays.sort(arr);
        helper(arr, arr.length-1, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
    
    private void helper(int[] arr, int i, List<Integer> subset, HashSet<List<Integer>> ans) {
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