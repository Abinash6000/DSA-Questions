class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i<n; i++) {
            int[] freqCount = new int[26];
            freqCount[s.charAt(i)-'a']++;
            int min = 1, max = 1;

            for(int j = i+1; j<n; j++) {
                char currChar = s.charAt(j);
                freqCount[currChar-'a']++;
                int currCount = freqCount[currChar-'a'];

                if(currCount > max) max = currCount;
                
                min = 501;
                for(int k = 0; k<26; k++) {
                    if(freqCount[k] > 0) min = Math.min(min, freqCount[k]);
                }

                sum += max-min;
            }
        }

        return sum;
    }
}