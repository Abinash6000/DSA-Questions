class Solution {
    public int minOperations(int[] nums) {
        int countOfOnes = 0, n = nums.length;
        boolean gcdOne = false;
        int countOfNotOnes = 0;

        for(int i = 0; i<n; i++) {
            if(nums[i] == 1)
                countOfOnes++;
            else
                countOfNotOnes++;

            if(i != n-1) {
                if(gcd(nums[i], nums[i+1]) == 1)
                    gcdOne = true;
            }
        }

        if(!gcdOne)
            return -1;

        return countOfNotOnes-countOfOnes;
    }

    private int gcd(int a, int b) {
        if(b == 0)
            return a;

        return gcd(b, a%b);
    }
}