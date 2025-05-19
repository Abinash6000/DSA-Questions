class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        long totalSum = 0;

        // Arrays to store left and right contributions
        int[] left = new int[n];
        int[] right = new int[n];

        // Stack for computing previous smaller elements (left boundary)
        Stack<int[]> stack = new Stack<>();

        // Compute left contributions
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                count += stack.pop()[1]; // Accumulate count from popped elements
            }
            stack.push(new int[]{arr[i], count});
            left[i] = count;
        }

        // Clear stack for next smaller elements (right boundary)
        stack.clear();

        // Compute right contributions
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) { // Notice ">=" for handling duplicates
                count += stack.pop()[1];
            }
            stack.push(new int[]{arr[i], count});
            right[i] = count;
        }

        // Compute final sum
        for (int i = 0; i < n; i++) {
            totalSum = (totalSum + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) totalSum;
    }
}