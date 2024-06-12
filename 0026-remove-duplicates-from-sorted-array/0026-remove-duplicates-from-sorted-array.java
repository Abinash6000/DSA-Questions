class Solution {
    public int removeDuplicates(int[] nums) {
        int uniEle = 0;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] != nums[uniEle]) {
                nums[uniEle+1] = nums[i];
                uniEle++;
            }
        }

        return uniEle+1;
    }
}