class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>(); // store indices of leftBound and Bottom
        int maxWat = 0, i = 0, n = height.length;

        while(i < n) {
            if(st.isEmpty() || height[i] <= height[st.peek()]) {
                st.push(i++);

            } else { // we encountered a right boundry
                int rightBoun = i; // rightBoundary
                int bot = st.pop(); // bottom

                if(!st.isEmpty()) {
                    int leftBoun = st.peek(); // leftBoundary

                    int waterHei = st.isEmpty() ? 0 :
                        (Math.min(height[rightBoun], height[leftBoun]) - height[bot]); // water height
                    int waterWei = rightBoun - leftBoun - 1; // water width

                    maxWat += waterHei * waterWei;
                }
            }
        }

        return maxWat;
    }
}