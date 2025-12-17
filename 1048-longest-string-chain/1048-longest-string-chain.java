class Solution {
    public int longestStrChain(String[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        Arrays.sort(arr, (a,b) -> a.length() - b.length());

        int maxi = 1;
        for(int i = 0; i<arr.length; i++) {
            for(int prev = 0; prev < i; prev++) {
                if(isPredecessor(arr[i], arr[prev]) && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                }
            }

            if(dp[i] > maxi) 
                maxi = dp[i];
        }

        return maxi;
    }

    private boolean isPredecessor(String curr, String prev) {
        if(curr.length() != prev.length()+1)
            return false;

        int fst = 0, sec = 0;
        while(fst != curr.length())
            if(sec != prev.length() && curr.charAt(fst) == prev.charAt(sec)) {
                fst++; sec++;
            } else {
                fst++;
            }

        if(fst == curr.length() && sec == prev.length()) return true;
        else return false;

    }
}