class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m][n];

        calculatePrefixSum(preSum, m, n, matrix);

        int maxArea = 0;
        for(int i = 0; i<m; i++) {
            maxArea = Math.max(maxArea, calcMaxAreaHistogram(preSum[i], n));
        }

        return maxArea;
    }

    private int calcMaxAreaHistogram(int[] hist, int n) {
        int maxArea = 0;
        int[] pse = new int[n], nse = new int[n];
        calculatePse(pse, hist, n);
        calculateNse(nse, hist, n);

        for(int i = 0; i<n; i++) {
            maxArea = Math.max(maxArea, hist[i]*(nse[i]-pse[i]-1));
        }

        return maxArea;
    }

    void calculatePse(int[] pse, int[] hist, int n) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    void calculateNse(int[] nse, int[] hist, int n) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    private void calculatePrefixSum(int[][] preSum, int m, int n, char[][] matrix) {
        for(int j = 0; j<n; j++) {
            for(int i = 0; i<m; i++) {
                if(i == 0) {
                    if(matrix[i][j] == '1') preSum[i][j] = 1;
                    else preSum[i][j] = 0;
                } else {
                    if(matrix[i][j] == '0') preSum[i][j] = 0;
                    else preSum[i][j] = preSum[i-1][j] + 1;
                }
            }
        }
    }
}