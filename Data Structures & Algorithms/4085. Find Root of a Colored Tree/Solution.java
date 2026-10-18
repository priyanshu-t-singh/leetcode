// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int findColoredRoot(int[][] edges, String colors) {
        int n = colors.length();
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int cu = colors.charAt(u);
            int cv = colors.charAt(v);

            if (
                cu == 'R' && cv == 'B' ||
                cu == 'B' && cv == 'W' ||
                cu == 'W' && cv == 'R'
            ) {
                adjList.get(u).add(v);
            }

            if (
                cu == 'B' && cv == 'R' ||
                cu == 'W' && cv == 'B' ||
                cu == 'R' && cv == 'W'
            ) {
                adjList.get(v).add(u);
            }
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> node = adjList.get(i);
            for (int j = 0; j < node.size(); j++) {
                // if indegree is more than 2, then it is not a tree
                // because edges in our case is n-1, so there will be
                // only one node with indegree of 0
                indegree[node.get(j)]++;
            }

            if (node.size() > 2) { // more than 2 children
                return -1;
            }
        }

        int count = 0;
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                count++;
                result = i;
            }
        }

        // since it's a tree it is guranteed that atleast one node
        // will have indegree of 0
        if (count > 1) {
            return -1;
        }

        return result;
    }
}
