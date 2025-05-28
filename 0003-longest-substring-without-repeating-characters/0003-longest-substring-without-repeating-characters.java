class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0, j = 0, n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>(); // char, count
        
        while(j<n) {
            char currCh = s.charAt(j);
            hm.put(currCh, hm.getOrDefault(currCh, 0)+1);

            while(hm.get(currCh) > 1) {
                hm.put(s.charAt(i), hm.get(s.charAt(i))-1);
                i++;
            }
            
            res = Math.max(res, j-i+1);
            j++;
        } 

        return res;
    }
}