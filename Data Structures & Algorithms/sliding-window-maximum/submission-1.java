class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int resultIndex = 0;

        for (int right = 0; right < n; right++) {

            // 1. Xóa index đã ra khỏi window
            while (!deque.isEmpty()
                    && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // 2. Xóa các phần tử nhỏ hơn phần tử mới
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // 3. Thêm index hiện tại
            deque.offerLast(right);

            // 4. Khi window đủ k phần tử
            if (right >= k - 1) {
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }

        return result;
    }
}