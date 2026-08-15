class Solution {
    public int search(int[] nums, int target) {
        int mid = nums.length / 2;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (target > nums[mid]) {
                l = mid + 1;
                mid = l + (r - l) / 2;
                continue;
            } else if (target < nums[mid]) {
                r = mid - 1;
                mid = l + (r - l) / 2;
                continue;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
