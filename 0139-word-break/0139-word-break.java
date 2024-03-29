class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> hm = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set, hm);
    }

    private boolean helper(String s, Set<String> set, HashMap<String, Boolean> hm) {
        if(s.length() == 0) return true;
        if(hm.containsKey(s)) return hm.get(s);

        for(int i = 1; i<=s.length(); i++) {
            if (set.contains(s.substring(0,i)) && helper(s.substring(i), set, hm)) {
                hm.put(s, true);
                return true;
            }
        }

        hm.put(s, false);
        return false;
    }
}