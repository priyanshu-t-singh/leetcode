// Time Complexity: O(N + M), where N is the number of nodes and M is the number of edges in the graph.
// Space Complexity: O(N), where N is the number of nodes in the graph.
class Solution {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<Node, Node>());
    }

    private Node dfs(Node node, Map<Node, Node> mp) {
        if (node == null) return null;
        if (mp.containsKey(node)) {
            return mp.get(node);
        }

        Node clone = new Node(node.val);
        mp.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, mp));
        }

        return clone;
    }
}
