class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0, count = 0, curr = -10001;

        for(int j = 0; j<n; j++) {
            if(curr == nums[j]) {
                count++;
            } else {
                count = 1;
                curr = nums[j];
            }

            if(count == 1 || count == 2) {
                nums[i] = curr;
                i++;
            }
        }

        return i;
    }
}