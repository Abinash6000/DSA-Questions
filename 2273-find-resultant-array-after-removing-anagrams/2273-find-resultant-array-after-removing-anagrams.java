class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i<words.length; i++)
            res.add(words[i]);

        boolean adjAna = false;
        do {
            adjAna = false;
            for(int i = 1; i<res.size(); i++) {
                String curr = res.get(i);
                String prev = res.get(i-1);
                char[] currAr = curr.toCharArray();
                char[] prevAr = prev.toCharArray();
                Arrays.sort(currAr);
                Arrays.sort(prevAr);
                String sortedCurr = Arrays.toString(currAr);
                String sortedPrev = Arrays.toString(prevAr);

                if(sortedCurr.equals(sortedPrev)) {
                    res.remove(i);
                    adjAna = true;
                }
            }
        } while(adjAna);

        return res;
    }
}