class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        for (int i = 0; i < arrivalTime.length; i++) {
            arrivalTime[i] %= period;
        }

        int maxLight = Integer.MIN_VALUE;
        for (int i = 0; i < lights.length; i++) {
            maxLight = Math.max(maxLight, lights[i]);
        }

        int maxPenalty = 0;
        for (int i = 0; i < arrivalTime.length; i++) {
            if (arrivalTime[i] < maxLight) {
                continue;
            }

            maxPenalty = Math.max(maxPenalty, period - arrivalTime[i]);
        }

        return maxPenalty;
    }
}
