class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxEle = -1;
        for(int pile : piles) {
            maxEle = Math.max(maxEle, pile);
        }
        
        int st = 1, ed = maxEle, mid = -1;
        while(st <= ed) {
            mid = st + (ed - st)/2;
            int hours = calculateHours(piles, mid);
            if(hours <= h) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }
        return st;
    }

    private int calculateHours(int[] piles, int k) { // k is current speed
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil((double)pile/k);
        }
        return hours;
    }
}