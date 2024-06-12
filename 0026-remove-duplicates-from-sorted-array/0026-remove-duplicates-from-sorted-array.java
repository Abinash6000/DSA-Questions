class Solution {
    public int removeDuplicates(int[] nums) {
        int uniEle = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] != nums[uniEle-1]) {
                nums[uniEle] = nums[i];
                uniEle++;
            }
        }

        return uniEle;
    }
}