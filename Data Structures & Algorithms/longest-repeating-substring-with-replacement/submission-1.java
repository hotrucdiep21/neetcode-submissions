class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxFreq = 0;
        int[] count = new int[26];

        while(right < s.length()) {
            char rightChar = s.charAt(right);
            int rightIndex = rightChar - 'A';
            count[rightIndex]++;

            maxFreq = Math.max(maxFreq, count[rightIndex]);

            int windowSize = right -left + 1;
            int replacementsNeeded = windowSize - maxFreq;

            while(replacementsNeeded > k) {
                char leftChar = s.charAt(left);
                int leftIndex = leftChar - 'A';

                count[leftIndex]--;
                left++;

                windowSize = right - left + 1;
                replacementsNeeded = windowSize - maxFreq;
            }
            maxLength = Math.max(maxLength, windowSize);
            right++;
        }
        return maxLength;
    }
}
