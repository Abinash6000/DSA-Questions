class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) total += b;

        long left = 0;
        long right = total / n; // max possible runtime

        while (left < right) {
            long mid = (left + right + 1) / 2;
            long usable = 0;

            for (int b : batteries) {
                usable += Math.min((long)b, mid);
            }

            if (usable >= mid * n) {
                left = mid;   // feasible, try higher
            } else {
                right = mid - 1; // not feasible
            }
        }
        return left;
    }
}
