// Algorithm: Topological Sort using Kahn's Algorithm
// Time Complexity: O(V + E), where V is the number of courses and E is the number of prerequisites
// Space Complexity: O(V + E), for the adjacency list and the inbound array
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] inbound = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj.get(i)) {
                inbound[neighbor]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inbound[i] == 0) q.offer(i);
        }

        int[] result = new int[numCourses];
        int i = numCourses;
        while (!q.isEmpty()) {
            int node = q.poll();
            result[--i] = node;

            for (int neighbor : adj.get(node)) {
                inbound[neighbor]--;
                if (inbound[neighbor] == 0) q.offer(neighbor);
            }
        }

        if (i == 0) return result;
        return new int[0];
    }
}
