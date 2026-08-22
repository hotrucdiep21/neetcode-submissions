class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // phase 1
        int top = 0;
        int bottom = matrix.length - 1;
        int midRow = 0;

        while (top <= bottom) {
            midRow = top + (bottom - top) / 2;
            int first = matrix[midRow][0];
            int last = matrix[midRow][matrix[midRow].length - 1];

            if (first > target) {
                bottom = midRow - 1;
            } else if (last < target) {
                top = midRow + 1;
            } else {
                break;
            }
        }

        // phase 2:
        int l = 0;
        int r = matrix[midRow].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (matrix[midRow][mid] < target) {
                l = mid + 1;
            } else if (matrix[midRow][mid] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
