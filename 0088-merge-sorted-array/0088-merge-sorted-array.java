class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = m+n-1, p3 = n-1;

        while(p1>= 0 && p3 >= 0) {
            if(nums1[p1] <= nums2[p3]) {
                nums1[p2--] = nums2[p3--];
            } else {
                nums1[p2--] = nums1[p1--];
            }
        }

        // if p3 becomes -1, we don't need to do anything anymore
        // if p1 becomes -1, we need to copy elements of nums2 to nums1
        while(p3 >= 0) {
            nums1[p2--] = nums2[p3--];
        }
    }
}