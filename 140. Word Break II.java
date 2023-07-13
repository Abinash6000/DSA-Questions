class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> possSent = new ArrayList<>();
		solveWordBreak(s, wordDict, possSent, "");
		return possSent;
    }

    private static void solveWordBreak(
		String s, 
		List<String> dict, 
		List<String> possSent, 
		String currSent) {
			// base case
			if(s == "") {
				possSent.add(currSent);
				return;
			}

			for(int k = 1; k<=s.length(); k++) {
				String wordInS = s.substring(0, k);
				if(!dict.contains(wordInS)) continue;

				// cond when it breaks here
				String tmpCurrSent = currSent;
				if(currSent == "") {
					tmpCurrSent = wordInS;
				} else {
					tmpCurrSent += " " + wordInS;
				}

				solveWordBreak(s.substring(k, s.length()), dict, possSent, tmpCurrSent);

				// cond when it doesn't breaks here, will be covered in next loop
			}
	}
}
