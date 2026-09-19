class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLength = 0, maxFreq = 0;
        int[] count = new int[26];

        while (right < s.length()) {
            int rightIndex = s.charAt(right) - 'A';
            count[rightIndex]++;

            maxFreq = Math.max(maxFreq, count[rightIndex]);

            if ((right - left + 1) - maxFreq > k) {
                int leftChar = s.charAt(left);
                int leftIndex = leftChar - 'A';

                count[leftIndex]--;

                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}
