class Solution {
    public int splitArray(int[] nums, int k) {
        int st = 0, ed = (int)1e9, mid;
        while(st <= ed) {
            mid = st + (ed-st)/2; // mid denotes the largest sum
            if(possibleToSplit(nums, mid, k)) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }

        return st;
    }

    private boolean possibleToSplit(int[] nums, int mid, int k) {
        int count = 1, currSum = 0;
        for(int num : nums) {
            if(num > mid) return false;
            currSum += num;
            if(currSum > mid) {
                currSum = num;
                count++;
                if(count > k) return false;
            }
        }
        return true;
    }
}