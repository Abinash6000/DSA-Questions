class Solution {
    public List<String> letterCombinations(String digits) {
        String keypad[] = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();

        helper(keypad, digits, 0, res, "");
        return res.size() == 1 ? new ArrayList<>() : res;
    }

    private void helper(String[] keypad, String digs, int i, List<String> res, String comb) {
        if(i == digs.length()) {
            res.add(comb);
            return;
        }

        char currDig = digs.charAt(i);
        String currLets = keypad[currDig-'2'];
        for(char let : currLets.toCharArray()) {
            helper(keypad, digs, i+1, res, comb+let);
        }
    }
}