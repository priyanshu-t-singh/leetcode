class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int totalTime = 0;
        int currFloor = 0;

        for (int req : requests) {
            if (currFloor != req) {
                totalTime += Math.abs(currFloor - req);
                currFloor = req;
            }
        }

        return totalTime;
    }
}
