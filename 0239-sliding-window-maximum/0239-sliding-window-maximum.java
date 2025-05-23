class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i<k; i++) {
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.removeLast();
            q.add(i);
        }

        res[0] = nums[q.peek()];
        int i = 1, j = k;
        if(q.peekLast() == 0) q.removeLast();

        while(j<n) {
            if(!q.isEmpty() && q.peekFirst() < i) q.removeFirst();
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[j])
                q.removeLast();
            q.add(j);

            res[i] = nums[q.peek()];

            i++;j++;
        }

        return res;
    }
}