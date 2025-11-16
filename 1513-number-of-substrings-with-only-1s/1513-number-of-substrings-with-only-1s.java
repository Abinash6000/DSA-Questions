class Solution {
    public int numSub(String s) {
        long count = 0, sum = 0;
        int mod = (int)1e9 + 7;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                sum = (sum + (count * (count + 1) / 2)) % mod;
                count = 0;
            }
        }

        sum = (sum + (count * (count + 1) / 2)) % mod;

        return (int)sum;
    }
}
