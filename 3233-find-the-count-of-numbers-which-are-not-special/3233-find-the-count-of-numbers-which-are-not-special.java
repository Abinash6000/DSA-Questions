public class Solution {
    public int nonSpecialCount(int l, int r) {
        int max = (int) Math.sqrt(r);
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int count = r - l + 1;
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                long square = (long) i * i;
                if (square >= l && square <= r) {
                    count--;
                }
            }
        }
        return count;
    }
}