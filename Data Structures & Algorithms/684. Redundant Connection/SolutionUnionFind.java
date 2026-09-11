// Time Complexity: O(n + e * α(n)), where n is the number of nodes, e is the number of edges, and α(n) is the inverse Ackermann function.
// Space Complexity: O(n), where n is the number of nodes.
// α(n) is a very slowly growing function, so for all practical purposes, it can be considered a constant.
class SolutionUnionFind {
    private int[] parent;
    private int[] size;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        this.parent = new int[n+1];
        this.size = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            if (!unionFind(edge[0], edge[1])) {
                return edge;
            }
        }

        return null;
    }

    private boolean unionFind(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return false;

        if (pu < pv) {
            int tmp = pu;
            pu = pv;
            pv = tmp;
        }

        parent[pv] = parent[pu];
        size[pu] += size[pv];

        return true;
    }

    private int findParent(int node) {
        if (node != parent[node]) {
            parent[node] = findParent(parent[node]);
        }
        return parent[node];
    }
}