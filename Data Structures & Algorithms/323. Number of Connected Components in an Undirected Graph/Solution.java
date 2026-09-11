// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V + E) for the adjacency list and O(V) for the visited array.
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(adjList, visited, i, -1);
            }
        }

        return count;
    }

    private void dfs(List<List<Integer>> adjList, boolean[] visited, int node, int parent) {
        if (visited[node]) return;
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (neighbor != parent) {
                dfs(adjList, visited, neighbor, node);
            }
        }
    }
}
