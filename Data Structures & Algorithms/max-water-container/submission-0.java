class Solution {
    public int maxArea(int[] heights) {
        // 1. Create l vs r
        // 2. Creat a variable to store result
        // 3. Calculate water = width x min(hieght[l], height[r])
        // 4. Compare height[l] and height[r] to decide which one should be shift
        int water = 0;
        int cal = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            cal = (r - l) * Math.min(heights[l], heights[r]);
            water = Math.max(water, cal);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return water;
    }
}
