class Solution {
    public int divide(int dividend, int divisor) {
        long n = Math.abs((long)dividend), d = Math.abs((long)divisor); // numerator n and denominator d
        long ans = 0;
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;

        if(n == Math.abs((long)1<<31) && sign == 1) 
            return Integer.MAX_VALUE;
        if(n == (Math.abs((long)1<<31)) && sign == -1)
            return Integer.MIN_VALUE;

        while(n >= d) { // till denominator <= numerator
            int count = 0;
            while(n >= d<<(count+1))
                count++;
            ans += 1<<count; // ans += 2^count
            n -= d*(1<<count);
        }

        if(ans == (1<<31) && sign == 1) 
            return Integer.MAX_VALUE;
        if(ans == (1<<31) && sign == -1)
            return Integer.MIN_VALUE;

        return (int)ans*sign;
    }
}