class Solution {
    int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long oddPlaces = n/2; // odd places will have 4 digits to put 2,3,5,7
        long evenPlaces = n-oddPlaces;

        long res = 1;
        res = (long) (power(4, oddPlaces)%mod);
        res = ((res * (long) (power(5, evenPlaces)%mod))%mod);
        
        return (int)res%mod;
    }

    private long power(long x,long y){// this method computes pow(x,y) in O(logn) using divide & conquer
        long temp;
        if(y==0) return 1;//base case (x power 0 = 1)
        temp=power(x,y/2);//computing power for pow(x,y/2) -> divide & conquer step
        if(y%2==0) return (temp*temp)%mod; //using that result of subproblem (2 power 2 = 2 power 1 * 2 power 1)
        else return (x*temp*temp)%mod;//using that result of subproblem (2 power 3 = 2 power 1 * 2 power 1 * 2)
		// if y is odd, x power y = x power y/2 * x power y/2 * x
		// if y is even, x power y = x power y/2 * x power y/2
    }
}