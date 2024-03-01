class Solution {
    public void sortColors(int[] nums) {
        int st = 0, ed = nums.length-1;
        for(int i = 0; i<=ed; i++) {
            if(nums[i] == 0) {
                int tmp = nums[st];
                nums[st] = nums[i];
                nums[i] = tmp;
                st++;
            } else if(nums[i] == 2) {
                int tmp = nums[ed];
                nums[ed] = nums[i];
                nums[i] = tmp;
                ed--;
                i--;
            }
        }
    }
}