// Time Complexity: O(d^n + m)
// Space Complexity: O(d^n + m)
// where d is the number of digits (10), n is the number of wheels (4), and m is the number of deadends.
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        int turns = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String lock = q.poll();
                if (target.equals(lock)) return turns;

                char[] arr = lock.toCharArray();
                for (int i = 0; i < 4; i++) {
                    int wheel = arr[i] - '0';
                    arr[i] = (char) (((wheel + 1) % 10) + '0');
                    String inc = new String(arr);
                    if (!visited.contains(inc)) {
                        q.offer(inc);
                        visited.add(inc);
                    }

                    arr[i] = (char) (((wheel - 1 + 10) % 10) + '0');
                    String dec = new String(arr);
                    if (!visited.contains(dec)) {
                        q.offer(dec);
                        visited.add(dec);
                    }
                    arr[i] = (char) ('0' + wheel);
                }
            }
            turns++;
        }

        return -1;
    }
}
