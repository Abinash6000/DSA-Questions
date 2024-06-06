class Solution {
    public int removeDuplicates(int[] nums) {
        int uniEle = 1, prevNum = nums[0];
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] != prevNum) {
                nums[uniEle] = nums[i];
                uniEle++;
                prevNum = nums[i];
            }
        }

        return uniEle;
    }
}