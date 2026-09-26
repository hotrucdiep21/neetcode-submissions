class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0, remaining = t.length();

        while (right < s.length()) {
            int rightChar = s.charAt(right);
            if (need[rightChar] > 0) {
                remaining--;
            }
            need[rightChar]--;

            while (remaining == 0) {
                int windowSize = right - left + 1;
                if (windowSize < minLength) {
                    minLength = windowSize;
                    start = left;
                }
                int leftChar = s.charAt(left);
                need[leftChar]++;
                if (need[leftChar] > 0) {
                    remaining++;
                }
                left++;
            }
            right++;
        }
        if(minLength == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLength);
    }
}
