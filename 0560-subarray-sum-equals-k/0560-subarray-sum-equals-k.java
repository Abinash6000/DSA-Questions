class Solution {
    public int subarraySum(int[] nums, int k) {
        int currSum = 0, count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>(); // sum, countOfTheSum(how many times we've encountered the 'sum' which we're storing in the key)
        hm.put(0, 1);
        
        for(int i = 0; i<nums.length; i++) {
            currSum += nums[i];
            int reqSum = currSum-k; // currSum - target
            
            if(hm.containsKey(reqSum)) {
                count += hm.get(reqSum);
            }
                
            hm.put(currSum, hm.getOrDefault(currSum, 0)+1);
        }
        
        return count;
    }
}