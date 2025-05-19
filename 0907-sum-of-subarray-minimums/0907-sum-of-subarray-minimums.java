class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;

        return (int) sumOfSubarrayMins(arr, MOD);
    }

    private long sumOfSubarrayMins(int[] nums, int mod) {
        long res = 0;
        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int[] leftCont = new int[n], rightCont = new int[n];

        // calculate left contributions
        for(int i = 0; i<n; i++) {
            int num = nums[i];
            int count = 1;

            while(!st.isEmpty() && nums[st.peek()] >= num) {
                st.pop();
            }

            leftCont[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        // calculate right contributions
        for(int i = n-1; i>=0; i--) {
            int num = nums[i];
            int count = 1;

            while(!st.isEmpty() && nums[st.peek()] > num) {
                st.pop();
            }

            rightCont[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        // calculate res
        for(int i = 0; i<n; i++) {
            res = (res + (long) (nums[i]*leftCont[i]*rightCont[i])) % mod;
        }

        return res;
    }
}