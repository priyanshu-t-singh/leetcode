class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int nearest = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < drones.length; i++) {
            int d = manhattanDistance(drones[i], target);
            if (d <= drones[i][2] && nearest > d) {
                nearest = d;
                idx = i;
            }
        }

        return idx;
    }

    private int manhattanDistance(int[] drone, int[] target) {
        return Math.abs(drone[0] - target[0]) + Math.abs(drone[1] - target[1]);
    }
}
