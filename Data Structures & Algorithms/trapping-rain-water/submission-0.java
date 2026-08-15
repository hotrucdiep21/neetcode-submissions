class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (l < r) {
            // update leftMax và rightMax
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            if (leftMax < rightMax) {
                water += leftMax - height[l];
                l++;
            } else {
                water += rightMax - height[r];
                r--;
            }
        }

        return water;
    }
}