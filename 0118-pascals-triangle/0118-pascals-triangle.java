class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<numRows; i++) { // row
            List<Integer> currRow = new ArrayList<>();

            for(int j = 0; j<=i; j++) { // col
                int comb = combination(i, j);
                currRow.add(comb);
            }

            res.add(currRow);
        }

        return res;
    }

    // finding n_C_r in minimal time
    // (row-1)_C_(col-1) // combination

    private int combination(int n, int r) {
        int res = 1;

        for(int i = 0; i<r; i++) {
            res *= n-i;
            res /= (i+1);
        }

        return res;
    }
}