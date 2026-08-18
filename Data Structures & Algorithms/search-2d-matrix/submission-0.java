class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Phase 1:
        int top = 0;
        int bottom = matrix.length - 1;
        int cadidateRow = -1;

        while (top <= bottom) {
            int midRow = top + (bottom - top) / 2;

            int first = matrix[midRow][0];
            int last = matrix[midRow][matrix[midRow].length - 1];

            if (target < first) {
                bottom = midRow - 1;
            } else if (target > last) {
                top = midRow + 1;
            } else {
                cadidateRow = midRow;
                break;
            }
        }
        if (cadidateRow == -1) {
            return false;
        }

        // Phase 2:
        // Binary Search 704 trong candidate row
        int l = 0;
        int r = matrix[cadidateRow].length - 1;

        while (l <= r) {
            int tempMid = l + (r - l) / 2;
            if (matrix[cadidateRow][tempMid] < target) {
                l = tempMid + 1;
            } else if (matrix[cadidateRow][tempMid] > target) {
                r = tempMid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
