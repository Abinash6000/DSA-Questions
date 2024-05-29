class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums) {
            if(hs.contains(n)) return n;
            else hs.add(n);
        }
        return -1;
    }
}