class Solution {
    public int totalMoney(int n) {
        int st = 1, res = 0;
        while(n != 0) {
            for(int i = st; n > 0 && i<st+7; i++) {
                res += i;
                n--;
            }
            st++;
        }

        return res;
    }
}