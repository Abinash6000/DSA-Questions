class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0)
            return -1;

        boolean possible = false;
        for(int i = 1; i<=9; i++)
            if(k*i % 10 == 1)
                possible = true;

        if(!possible)
            return -1;

        int numOfOnes = 1 % k;
        int currNum = 1;
        while(currNum != 0) {
            currNum = currNum * 10 + 1;
            currNum = currNum % k;

            numOfOnes++;
        }

        return numOfOnes;
    }
}