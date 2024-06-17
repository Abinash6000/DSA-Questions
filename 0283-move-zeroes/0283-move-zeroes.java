class Solution {
    public void moveZeroes(int[] nums) {
        int st = 0;
        int countZero = 0;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                countZero++;
            } else {
                nums[st++] = nums[i];
            }
        }

        int j = nums.length-1;
        while(countZero != 0) {
            nums[j--] = 0;
            countZero--;
        }
    }
}