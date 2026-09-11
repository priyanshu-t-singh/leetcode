// Time Complexity: O(V + E), where V is the number of courses and E is the number of prerequisites.
// Space Complexity: O(V + E) for the adjacency list and O(V) for the visited and recursion stack arrays.
class SolutionDetectCycle {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclic(adjList, visited, recStack, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(List<List<Integer>> adjList, boolean[] visited, boolean[] recStack, int i) {
        if (recStack[i]) return true; // cycle detected
        if (visited[i]) return false; // already visited

        visited[i] = true;
        recStack[i] = true;

        for (int neighbor : adjList.get(i)) {
            if (isCyclic(adjList, visited, recStack, neighbor)) {
                return true;
            }
        }

        recStack[i] = false; // backtrack
        return false;
    }
}
