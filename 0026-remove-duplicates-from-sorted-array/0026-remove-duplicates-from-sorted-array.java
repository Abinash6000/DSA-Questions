class Solution {
    public int removeDuplicates(int[] nums) {
        int uniIdx = 0, uniIdxFind = 0, k = 1;
        for(; uniIdxFind < nums.length; uniIdxFind++) {
            if(nums[uniIdx] != nums[uniIdxFind]) {
                uniIdx++;
                nums[uniIdx] = nums[uniIdxFind];
                k++;
            }
        }
        
        return k;
    }
}