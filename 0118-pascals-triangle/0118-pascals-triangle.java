class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<numRows; i++) { // row
            List<Integer> currRow = new ArrayList<>();
            int currEle = 1;

            for(int j = 0; j<=i; j++) { // col
                if(j == 0) {
                    currRow.add(currEle);
                    continue;
                }
                currEle *= (i-j+1);
                currEle /= (j);
                currRow.add(currEle);
            }

            res.add(currRow);
        }

        return res;
    }
}