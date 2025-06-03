class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128]; // Frequency map for ASCII characters

        // Populate frequency map with characters from t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0; // Window boundaries
        int minLen = Integer.MAX_VALUE; // Length of the minimum window found
        int minStart = 0; // Starting index of the minimum window
        int required = t.length(); // Number of characters needed to form a valid window

        char[] chars = s.toCharArray();

        // Expand the right end of the window
        while (right < chars.length) {
            if (freq[chars[right]]-- > 0) {
                required--; // Needed character found
            }

            // Contract the window from the left as long as it's valid
            while (required == 0) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                // Remove the leftmost character and update the frequency map
                if (++freq[chars[left]] > 0) {
                    required++; // A required character is now missing
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}