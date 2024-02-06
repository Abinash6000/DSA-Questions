class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> hm = new HashMap<>();
        return helper(s, wordDict, hm);
    }

    private boolean helper(String s, List<String> wordDict, HashMap<String, Boolean> hm) {
        if(wordDict.contains(s)) return true;
        if(hm.containsKey(s)) return hm.get(s);

        for(int i = 1; i<s.length(); i++) {
            // divide the string into two parts...
            if(helper(s.substring(0,i), wordDict, hm) && helper(s.substring(i, s.length()), wordDict, hm)) {
                hm.put(s, true);
                return true;
            }
        }

        hm.put(s, false);
        return false;
    }
}