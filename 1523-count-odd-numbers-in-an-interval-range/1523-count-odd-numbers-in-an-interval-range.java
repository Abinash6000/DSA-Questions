class Solution {
    public int countOdds(int low, int high) {
        int len = high-low+1;
        int res = (len+1)/2;
        return low%2 == 0 && high%2 == 0 ? res -1 : res;
    }
}