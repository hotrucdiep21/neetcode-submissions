class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLength = 0, maxFreq = 0;
        int[] count = new int[26];

        while (right < s.length()) {
            int rightIndex = s.charAt(right) - 'A';
            count[rightIndex]++;

            maxFreq = Math.max(maxFreq, count[rightIndex]);

            // If changes needed exceed k, shrink the window from the left
            if ((right - left + 1) - maxFreq > k) {
                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;
                left++;
            }

            // The window [left, right] is now valid
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}