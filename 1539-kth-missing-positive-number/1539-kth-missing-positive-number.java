class Solution {
    public int findKthPositive(int[] arr, int k) {
        int miss = 0;
        int prev = 0;

        for(int i = 0; i<arr.length; i++) {
            int newMiss = miss + (arr[i] - (prev+1));
            if(newMiss > k) {
                return prev + (k - miss);
            }

            miss = newMiss;

            prev = arr[i];
        }

        return prev + (k - miss);
    }
}