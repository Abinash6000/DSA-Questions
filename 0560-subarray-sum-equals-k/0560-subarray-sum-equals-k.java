class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>(); // sum, count
        mp.put(0, 1);
        int currSum = 0;
        int count = 0;

        for(int i = 0; i<nums.length; i++) {
            // currSum - prevSum = k => reqSum = currSum - k
            currSum += nums[i];
            int reqSum = currSum - k;
            if(mp.containsKey(reqSum)) count += mp.get(reqSum);
            mp.put(currSum, mp.getOrDefault(currSum, 0)+1);
        }

        return count;
    }
}