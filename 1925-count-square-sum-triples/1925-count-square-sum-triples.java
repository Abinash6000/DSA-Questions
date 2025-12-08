class Solution {
    public int countTriples(int n) {
        int res = 0;

        for(int a = 1; a <= n; a++) {
            for(int b = 1; b <= n; b++) {
                int aSq = a*a;
                int bSq = b*b;
                int cSq = aSq+bSq;
                int c = (int)Math.sqrt(cSq);

                if(Math.sqrt(cSq) == c && c <= n)
                    res++;
            }
        }

        return res;
    }
}