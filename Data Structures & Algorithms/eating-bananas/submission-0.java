class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;

        int high = piles[0];
        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }
        int candidateK = 0;

        while (low <= high) {
            int midRateEat = low + (high - low) / 2;
            int hours = 0;
            for (int pile : piles) {
                if (pile % midRateEat != 0) {
                    hours += pile / midRateEat;
                    hours++;
                } else {
                    hours += pile / midRateEat;
                }
            }

            if (hours > h) {
                low = midRateEat + 1;
            } else {
                candidateK = midRateEat;
                high = midRateEat - 1;
            }
        }
        return candidateK;
    }
}
