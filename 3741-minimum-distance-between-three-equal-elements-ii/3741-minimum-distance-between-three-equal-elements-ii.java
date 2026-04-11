class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i<nums.length; i++) 
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        int min = Integer.MAX_VALUE;
        for(List<Integer> val : mp.values()) {
            int i = 0, j = 2;
            while(j < val.size()) {
                min = Math.min(min, 2*(val.get(j) - val.get(i)));
                i++; j++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}