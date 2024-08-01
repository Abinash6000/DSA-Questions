class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int st = 1, ed = 25000000, mid = -1;
        while(st <= ed) {
            mid = st + (ed-st)/2; // minWeight
            if(possibleWithinDays(weights, days, mid)) {
                ed = mid-1; 
            } else {
                st = mid+1;
            }
        }

        return st;
    }

    private boolean possibleWithinDays(int weights[], int days, int minWeight) {
        int totalDays = 0;
        int totalWeight = 0;
        for(int i = 0; i<weights.length; i++) {
            if(weights[i] > minWeight) return false;

            totalWeight += weights[i];

            if(i+1 == weights.length || weights[i+1] + totalWeight > minWeight) {
                totalDays ++;
                totalWeight = 0;
            }
        }

        return totalDays <= days;
    }
}