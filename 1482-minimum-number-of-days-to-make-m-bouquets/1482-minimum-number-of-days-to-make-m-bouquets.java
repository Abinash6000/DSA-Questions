class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k > n) return -1; // impossible to make m bouquets

        int st = 1, ed = (int)1e9, mid = -1, res = -1;
        while(st <= ed) {
            mid = st + (ed - st)/2; // mid denotes the min no. of days
            if(isMidValid(bloomDay, m, k, mid)) {
                res = mid;
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }

        return res;
    }

    private boolean isMidValid(int[] bloomDay, int m, int k, int minDays) {
        int consecutiveFlowers = 0;
        int totalBouquets = 0;
        for(int day : bloomDay) {
            if(day <= minDays) {
                consecutiveFlowers++;
                if(consecutiveFlowers == k) {
                    totalBouquets++;
                    if(totalBouquets == m) break;
                    consecutiveFlowers = 0;
                }
            } else consecutiveFlowers = 0;
        }

        return totalBouquets == m;
    }
}