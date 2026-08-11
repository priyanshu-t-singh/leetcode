// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V + E) for the adjacency list, and O(V) for the visited and recStack arrays.
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                if (isCyclic(adj, visited, recStack, i, -1)) {
                    return false;
                }
            }
        }

        return count == 1;
    }

    private boolean isCyclic(List<List<Integer>> adj, boolean[] visited, boolean[] recStack, int i, int parent) {
        if (recStack[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        recStack[i] = true;

        for (int neighbor : adj.get(i)) {
            if (neighbor != parent && isCyclic(adj, visited, recStack, neighbor, i)) {
                return true;
            }
        }

        recStack[i] = false;
        return false;
    }
}
