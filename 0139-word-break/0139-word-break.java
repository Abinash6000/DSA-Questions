class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> hm = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set, hm);
    }

    private boolean helper(String s, Set<String> set, HashMap<String, Boolean> hm) {
        if(set.contains(s)) return true;
        if(hm.containsKey(s)) return hm.get(s);

        for(int i = 1; i<s.length(); i++) {
            // divide the string into two parts...
            if(helper(s.substring(0,i), set, hm) && helper(s.substring(i, s.length()), set, hm)) {
                hm.put(s, true);
                return true;
            }
        }

        hm.put(s, false);
        return false;
    }
}