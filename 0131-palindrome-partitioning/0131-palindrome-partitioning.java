class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, new ArrayList<>(), res);
        return res;
    }

    private void helper(String s, List<String> currPart, List<List<String>> res) {
        if(s.length() == 0) {
            res.add(new ArrayList<>(currPart));
            return;
        }

        for(int i = 1; i<=s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue;
            currPart.add(temp); // choose
            helper(s.substring(i, s.length()), currPart, res); // explore
            currPart.remove(currPart.size()-1); // unchoose
        }
    }

    private boolean isPalindrome(String s) {
        int st = 0, ed = s.length()-1;
        while(st<ed) {
            if(s.charAt(st++) != s.charAt(ed--)) return false;
        }

        return true;
    }
}