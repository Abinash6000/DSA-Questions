class Solution {
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer> negs = new ArrayList<>();
        int i = 0; int tmp_i = nums.length; boolean flag = true;
        for(; i<nums.length; i++) {
            if(nums[i] < 0) negs.add(0, (int)Math.pow(nums[i], 2));
            else {
                if(flag) {
                    tmp_i = i; flag = false;
                }
                nums[i] = (int)Math.pow(nums[i], 2);
            }
        }


        // i is at positive element in nums
        // j is at fist element of negs
        int j = 0; i = tmp_i;
        for(int k = 0; k<nums.length; k++) {
            if(j == negs.size() || i != nums.length && nums[i] < negs.get(j)) {
                nums[k] = nums[i];
                i++;
            } else {
                nums[k] = negs.get(j);
                j++;
            }
        }

        return nums;
    }
}