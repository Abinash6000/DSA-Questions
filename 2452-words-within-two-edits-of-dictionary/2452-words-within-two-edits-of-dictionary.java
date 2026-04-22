class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for(String q : queries) {
            for(String word : dictionary) {
                if(withinTwoEdits(q, word)) {
                    res.add(q);
                    break;
                }
            }
        }

        return res;
    }

    private boolean withinTwoEdits(String w1, String w2) {
        int edits = 0;
        for(int i = 0; i < w1.length(); i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            if(c1 != c2)
                edits++;

            if(edits > 2)
                return false;
        }

        return true;
    }
}