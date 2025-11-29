class Solution {
    public int reverse(int x) {
        long res = 0;

        while(x != 0) {
            int dig = x%10;
            res *= 10;
            res += dig;

            if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
                return 0;

            x = x/10;
        }

        return (int)res;
    }
}