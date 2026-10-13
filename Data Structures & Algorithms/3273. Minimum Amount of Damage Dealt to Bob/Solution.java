// Time Complexity: O(n log n)
// Space Complexity: O(n)
class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        Pair[] threatLevel = new Pair[n];

        // calculate the threat level. Lower threat level => higher priority
        for (int i = 0; i < n; i++) {
            int timeToHit = (int) Math.ceil((double) health[i] / power);
            threatLevel[i] = new Pair((double) timeToHit / damage[i], i);
        }

        // sort the threat level in ascending order
        Arrays.sort(threatLevel, (a, b) -> Double.compare(a.threatLevel, b.threatLevel));

        long totalDamage = 0;
        long cumulativeDamage = 0;
        for (int i = 0; i < n; i++) {
            cumulativeDamage += damage[i];
        }
        
        // calculate the total damage dealt to Bob based on the sorted threat levels
        for (Pair threat : threatLevel) {
            int idx = threat.index;
            int time_to_hit = (int) Math.ceil((double) health[idx] / power);

            totalDamage += cumulativeDamage * time_to_hit;
            cumulativeDamage -= damage[idx];
        }

        return totalDamage;
    }

    private class Pair {
        private double threatLevel;
        private int index;
        public Pair(double threatLevel, int index) {
            this.threatLevel = threatLevel;
            this.index = index;
        }
    }
}
