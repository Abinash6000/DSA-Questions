class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums2) {
            while(!st.empty() && st.peek() < num) {
                mp.put(st.pop(), num);
            }

            st.push(num);
        }

        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = mp.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}