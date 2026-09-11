// Time Complexity: O(E * (V + E)) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            adjList.get(edge[0]-1).add(edge[1]-1);
            adjList.get(edge[1]-1).add(edge[0]-1);
            if (!visited[edge[0]-1] && isCyclic(adjList, visited, edge[0]-1, -1)) {
                return edge;
            }
        }

        return null;
    }

    private boolean isCyclic(List<List<Integer>> adjList, boolean[] visited, int node, int parent) {
        if (visited[node]) {
            return true;
        }

        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (neighbor != parent && isCyclic(adjList, visited, neighbor, node)) {
                return true;
            }
        }

        visited[node] = false;
        return false;
    }
}
