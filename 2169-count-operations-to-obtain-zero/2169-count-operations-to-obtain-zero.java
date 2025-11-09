class Solution {
    public int countOperations(int nums1, int nums2) {
        if(nums1 == 0 || nums2 == 0) 
            return 0;

        if(nums1 > nums2)
            return 1 + countOperations(nums1-nums2, nums2);
        else
            return 1 + countOperations(nums1, nums2-nums1);
    }
}