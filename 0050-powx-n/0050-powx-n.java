class Solution {
    public double myPow(double x, int n) {
        if(n > 0) {
            return helper(x, n);
        } else {
            double p = helper(x, n);
            return 1/p;
        }

    }

    private double helper(double x, int n) {
        if(n == 0) return 1;

        if(n%2 == 0)
            return helper(x, n/2)*helper(x, n/2);
        else
            return helper(x, n/2)*helper(x,n/2)*x;
    }
}