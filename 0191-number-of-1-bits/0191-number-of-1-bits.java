class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;

        while(n != 0) {
            if((n & mask) == 1)
                res++;
            
            n >>= 1;
        }

        return res;
    }
}