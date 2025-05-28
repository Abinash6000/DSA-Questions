class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0, max = 0;
        for(int j = 0; j<s.length(); j++) {
            if(mp.containsKey(s.charAt(j)))
                mp.put(s.charAt(j), mp.get(s.charAt(j))+1);
            else mp.put(s.charAt(j), 1);

            while(mp.get(s.charAt(j))>1) {
                mp.put(s.charAt(i), mp.get(s.charAt(i))-1);
                if(mp.get(s.charAt(i)) == 0) mp.remove(s.charAt(i));
                i++;
            }
            max = Math.max(max, mp.size());
        }
        return max;
    }
}