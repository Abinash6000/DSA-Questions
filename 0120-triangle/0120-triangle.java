class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int mm[][] = new int[m+1][triangle.get(m-1).size()+1];

        for(int[] row : mm) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        mm[0][0] = triangle.get(0).get(0);
        for(int i = 1; i<m; i++) {
            mm[i][0] = mm[i-1][0] + triangle.get(i).get(0);
        }

        for(int i = 1; i<m; i++) {
            for(int j = 1; j<=i; j++) {

                List<Integer> row = triangle.get(i);
                mm[i][j] = row.get(j) + Math.min(mm[i-1][j], mm[i-1][j-1]);
            }
        }

        int min = Integer.MAX_VALUE;
        // mm[m-1][triangle.get(m-1).size()-1]
        for(int i = 0; i<m; i++)
            min = Math.min(mm[m-1][i], min);
        return min;
    }

    private int helper(List<List<Integer>> tri, int i, int j, int[][] mm) {
        if(i == tri.size()) return 0;
        if(mm[i][j] != 0) return mm[i][j];

        List<Integer> row = tri.get(i);
        int res = row.get(j) + Math.min(helper(tri, i+1, j, mm), helper(tri, i+1, j+1, mm));

        return mm[i][j] = res;
    }
}