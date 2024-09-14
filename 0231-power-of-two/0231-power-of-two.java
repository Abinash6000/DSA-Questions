class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;

        while(n!=0) {
            int get = n&1;
            n>>=1;
            if(get > 0 && n > 0) return false;
        }

        return true;
    }
}