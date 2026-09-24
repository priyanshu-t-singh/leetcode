// Time Complexity: O(nlogn)
// Space Complexity: O(n)
//      where n is the length of hand. We need to store the count of each card
//      in a HashMap and also store the unique cards in a PriorityQueue.
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize > 0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            count.put(hand[i], count.getOrDefault(hand[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(count.keySet());
        for (int i = 0; i < hand.length; i += groupSize) {
            int first = pq.peek();

            for (int j = 0; j < groupSize; j++) {
                if (count.getOrDefault(first + j, 0) == 0) {
                    return false;
                }
                count.put(first + j, count.get(first + j) - 1);
                if (count.get(first + j) == 0) {
                    pq.poll();
                }
            }
        }

        return true;
    }
}
