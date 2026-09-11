// Algorithm: Topological Sort using Kahn's Algorithm
// Time Complexity: O(V + E), where V is the number of courses and E is the number of prerequisites
// Space Complexity: O(V + E), for the adjacency list and the inbound array
class SolutionTopologicalSort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] inbound = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int node : adj.get(i)) {
                inbound[node]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inbound[i] == 0) q.offer(i);
        }

        int finishedCourses = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            finishedCourses++;

            for (int neighbor : adj.get(node)) {
                inbound[neighbor]--;
                if (inbound[neighbor] == 0) q.offer(neighbor);
            }
        }

        return finishedCourses == numCourses;
    }
}
