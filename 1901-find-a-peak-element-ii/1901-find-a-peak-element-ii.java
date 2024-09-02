class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int st = 0, ed = mat[0].length-1, mid = -1;

        while(st <= ed) {
            mid = st + (ed-st)/2;
            int maxRowIdx = findMaxRowIndex(mat, m, n, mid);
            int left = mid != 0 ? mat[maxRowIdx][mid-1] : -1;
            int right = mid != n-1 ? mat[maxRowIdx][mid+1] : -1;
            
            if(mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right) 
                return new int[]{maxRowIdx, mid};
            else if(mat[maxRowIdx][mid] < left)
                ed = mid-1;
            else
                st = mid+1;
        }

        return new int[]{-1, -1};
    }

    private int findMaxRowIndex(int[][] mat, int m, int n, int col) {
        int maxEle = -1, idx = -1;
        for(int i = 0; i<m; i++) {
            if(mat[i][col] > maxEle) {
                maxEle = mat[i][col];
                idx = i;
            }
        }

        return idx;
    }
}