class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();
        if (windowSize > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (int i = 0; i < windowSize; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Count, windowCount)) {
            return true;
        }

        for (int right = windowSize; right < s2.length(); right++) {
            windowCount[s2.charAt(right-windowSize) - 'a']--;
            windowCount[s2.charAt(right)-'a']++;

            if (Arrays.equals(windowCount, s1Count)) {
                return true;
            }
        }
        return false;
    }
}
