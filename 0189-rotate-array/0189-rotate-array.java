class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;

        int nMinK = n-k;
        reverse(0, nMinK-1, nums);
        reverse(nMinK, n-1, nums);
        reverse(0, n-1, nums);
    }

    private void reverse(int i, int j, int[] nums) {
        while(i<j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}