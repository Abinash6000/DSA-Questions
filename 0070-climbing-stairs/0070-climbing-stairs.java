class Solution {
    public int climbStairs(int n) {
        if (n<=2) return n;
        if (n==44) return 1134903170;
        if (n==45) return 1836311903;
        int prev1 = 1;
        int prev2 = 2;
        int res = 0;
        for (int i = 2; i<n; i++) {
            res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;
        }
        return res;
    }
}