class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) { // x + y = target
            int x = nums[i];
            int y = target-x;

            if (numToIndex.containsKey(y)) {
                return new int[] {numToIndex.get(y), i};
            }

            numToIndex.put(x, i);
        }

        return new int[] {};
    }
}