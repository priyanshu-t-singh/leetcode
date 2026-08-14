// Time Complexity: O(n + (e * alpha(n))) where n is the number of nodes and e is the number of edges.
// Space Complexity: O(n) for the size and parent arrays.
class SolutionDisjointUnionSet {
    private int[] size;
    private int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;

        size = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }

    private boolean union(int u, int v) {
        int pu = findBySize(u);
        int pv = findBySize(v);
        if (pu == pv) return false;

        if (size[pu] >= size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }

        return true;
    }

    private int findBySize(int node) {
        if (node != parent[node]) {
            parent[node] = findBySize(parent[node]);
        }
        return parent[node];
    }
}
