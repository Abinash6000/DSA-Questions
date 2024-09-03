class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = -1;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int st = 1, ed = max, mid;
        
        while(st <= ed) {
            mid = st+(ed-st)/2; // mid denotes the potential divisor
            if(isDivisorValid(nums, threshold, mid)) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }

        return st;
    }

    private boolean isDivisorValid(int[] nums, int thresh, int divisor) {
        int sum = 0;
        for(int num : nums) {
            sum += (int)Math.ceil((double)num/divisor);
        }

        return sum <= thresh;
    }
}