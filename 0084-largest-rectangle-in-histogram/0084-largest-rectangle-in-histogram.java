class Solution {
    public int largestRectangleArea(int[] heights) {
        // pse and nse
        int n = heights.length;
        int[] pse = new int[n]; // previous smaller element
        int[] nse = new int[n]; // next smaller element
        findPse(pse, heights, n);
        findNse(nse, heights, n);
        
        int max = 0;
        for(int i = 0; i<n; i++) {
            max = Math.max(max, heights[i]*(nse[i]-pse[i]-1));
        }

        return max;
    }

    private void printArray(int[] arr) {
        for(int e : arr) {
            System.out.print(e+" ");
        }
        System.out.println();
    }

    private void findNse(int[] nse, int[] heights, int n) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }

    private void findPse(int[] pse, int[] heights, int n) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }
}