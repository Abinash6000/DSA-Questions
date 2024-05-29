class Solution {
    public void sortColors(int[] nums) {
        int zeroId = 0;
        int twoId = nums.length-1;
        for(int i = 0; i <= twoId; i++) {
            if(nums[i] == 0) {
                nums[i] = nums[zeroId];
                nums[zeroId++] = 0;
            } else if(nums[i] == 2) {
                nums[i--] = nums[twoId];
                nums[twoId--] = 2;
            }
        }
    }
}