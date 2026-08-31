class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Đảm bảo nums1 luôn là mảng có độ dài nhỏ hơn để tối ưu thời gian tìm kiếm O(log(min(m, n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            // Điểm chia trên nums1 và nums2
            int partition1 = left + (right - left) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            // 4 phần tử xung quanh vạch phân hoạch
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Kiểm tra xem phân hoạch đã hợp lệ chưa
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Tổng số phần tử là số lẻ
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } 
                // Tổng số phần tử là số chẵn
                else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // Phân hoạch của nums1 quá lệch về bên phải, cần dịch sang trái
                right = partition1 - 1;
            } else {
                // Phân hoạch của nums1 quá lệch về bên trái, cần dịch sang phải
                left = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Dữ liệu đầu vào không hợp lệ.");
    }
}