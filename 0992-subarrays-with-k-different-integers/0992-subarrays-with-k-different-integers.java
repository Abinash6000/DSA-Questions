class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subAWKD(nums, k) - subAWKD(nums, k-1);
    }

    private int subAWKD(int[] nums, int k) {
        int st = 0, ed = 0, n = nums.length;
        int[] map = new int[n+1]; // num, count
        int count = 0; // count k or lesser diff ints
        int noOfEle = 0;

        while(ed < n) {
            map[nums[ed]]++;
            if(map[nums[ed]] == 1) noOfEle++;

            while(noOfEle > k) {
                count += ed - st;
                map[nums[st]]--;

                if(map[nums[st]] == 0) noOfEle--;
                st++;
            }

            ed++;
        }

        // add remaining subArrs from st to ed
        while(st < n) {
            count += ed - st;
            st++;
        }

        return count;
    }
}