class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLength = 0, maxFreq = 0;
        int[] count = new int[26];

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            int rightIndex = rightChar - 'A';
            count[rightIndex]++;

            maxFreq = Math.max(maxFreq, count[rightIndex]);

            int windowSize = right - left + 1;
            int replacementNeeded = windowSize - maxFreq;

            while(replacementNeeded > k) {
                char leftChar = s.charAt(left);
                int leftIndex = leftChar - 'A';

                count[leftIndex]--;
                left++;

                windowSize = right - left + 1;
                replacementNeeded = windowSize - maxFreq;
            }
            maxLength = Math.max(maxLength, windowSize);
            right++;
        }
        return maxLength;
    }
}
