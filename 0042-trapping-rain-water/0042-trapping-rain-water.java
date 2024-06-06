// https://www.youtube.com/watch?v=ZI2z5pq0TqA
class Solution {
    public int trap(int[] height) {
        
        int l = 0, r = height.length-1;
        int leftMax = height[l], rightMax = height[r];
        int water = 0;

        while(l < r) {
            if(leftMax < rightMax) {
                l += 1;
                leftMax = Math.max(leftMax, height[l]);
                water += leftMax - height[l];
            } else {
                r -= 1;
                rightMax = Math.max(rightMax, height[r]);
                water += rightMax - height[r];
            }
        }

        return water;
    }
}