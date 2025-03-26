class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;

        for(int e : nums) {
            if(count == 0) candidate = e;
            if(e == candidate) count++;
            else count--;
        }
        
        return candidate;
    }
}