class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int count = 0, curr = -1;

        for(int num : nums) {
            if(curr == num)
                count++;
            else {
                curr = num;
                count = 1;
            }

            if(count == nums.length/2)
                return curr;
        }

        return -1;
    }
}