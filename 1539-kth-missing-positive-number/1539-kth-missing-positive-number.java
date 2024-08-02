class Solution {
    public int findKthPositive(int[] arr, int k) {
        int st = 1, ed = 1001, mid;
        while(st <= ed) {
            mid = st + (ed-st)/2;
            int missingNos = calculateMissingNos(arr, mid);
            if(missingNos < k) st = mid+1;
            else ed = mid-1;
        }

        return st;
    }

    private int calculateMissingNos(int[] arr, int currMid) {
        int st = 0, ed = arr.length-1, m;
        while(st <= ed) {
            m = st + (ed-st)/2;
            if(arr[m] > currMid) ed = m-1;
            else st = m+1;
        }
        return currMid-st; // currMid - (numbers Present before currMid in the array)
    }
}