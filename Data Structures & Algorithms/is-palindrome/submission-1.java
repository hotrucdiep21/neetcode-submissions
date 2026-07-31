class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
