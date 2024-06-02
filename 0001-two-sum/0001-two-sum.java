class Solution {
    public int[] twoSum(int[] nums, int t) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            int x = nums[i];
            int y = t-x;
            if(hm.containsKey(y)) {
                ans = new int[]{i, hm.get(y)};
                return ans;
            } else hm.put(x, i);
        }

        return ans;
    }
}