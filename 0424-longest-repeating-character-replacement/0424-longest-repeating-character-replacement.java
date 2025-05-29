class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, start = 0, maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            freq[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(end) - 'A']);

            // window size - maxFreq gives required changes
            if ((end - start + 1) - maxFreq > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
                // there is no need to calc maxFreq again because
                // your result won't be updated unless the current window size is valid.
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
