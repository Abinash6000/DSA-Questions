class Solution {
    public int beautySum(String s) {
        int n = s.length(), min = 501, max = 0;
        int sum = 0;

        for(int i = 0; i<n; i++) {
            int[] freqCount = new int[26];
            freqCount[s.charAt(i)-'a']++;
            min = 501; max = 0;

            for(int j = i+1; j<n; j++) {
                char currChar = s.charAt(j);
                freqCount[currChar-'a']++;
                int currCount = freqCount[currChar-'a'];

                if(currCount > max) max = currCount;
                if(currCount < min) min = currCount;
                sum += max-min;
            }
        }

        return sum;
    }
}