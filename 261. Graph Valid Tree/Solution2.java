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

        Set<Integer> visited = new HashSet<>();
        if (dfs(adj, visited, 0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(List<List<Integer>> adj, Set<Integer> visited, int i, int parent) {
        if (visited.contains(i)) return false;

        visited.add(i);
        for (int neighbor : adj.get(i)) {
            if (neighbor != parent && dfs(adj, visited, neighbor, i)) {
                return true;
            }
        }

        return false;
    }
}
