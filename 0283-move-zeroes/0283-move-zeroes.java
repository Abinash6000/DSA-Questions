class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = nums.length-1; i>=0; i--) {
            if (nums[i]==0) {
                int n = i;
                while (n<nums.length-p-1) {
                    // swap
                    int temp = nums[n];
                    nums[n] = nums[n+1];
                    nums[n+1] = temp;
                    n++;
                }
                p++;
            }
        }
    }
}