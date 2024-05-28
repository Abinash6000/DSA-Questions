class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length-1;
        while(j >= 1 && nums[j] <= nums[j-1]) j--;

        if(j == 0) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        int i = j-1;
        j = nums.length-1;

        while(j >= 1 && nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        reverse(nums, i+1, nums.length-1);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++; j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}