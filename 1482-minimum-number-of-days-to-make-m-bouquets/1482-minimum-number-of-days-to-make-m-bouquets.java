class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > bloomDay.length) return -1; // impossible to make m bouquets

        int st = 1, ed = (int)1e9, mid = -1;
        while(st <= ed) {
            mid = st + (ed - st)/2; // mid denotes the min no. of days
            if(isPossibleBouquets(bloomDay, m, k, mid)) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }

        return st;
    }

    private boolean isPossibleBouquets(int[] bloomDay, int m, int k, int day) {
        int total = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;
            while (i < bloomDay.length && count < k && bloomDay[i] <= day) {
                count++;
                i++;
            }

            if (count == k) {
                total++;
                i--;
            }

            if (total >= m) {
                return true;
            }
        }

        return false;
    }
}