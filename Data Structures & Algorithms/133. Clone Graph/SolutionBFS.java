// Time Complexity: O(N + M), where N is the number of nodes and M is the number of edges in the graph.
// Space Complexity: O(N), where N is the number of nodes in the graph.
class SolutionBFS {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> mp = new HashMap<>();

        Node root = new Node(node.val);
        mp.put(node, root);
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            Node clone = mp.get(cur);

            for (Node neighbor : cur.neighbors) {
                if (!mp.containsKey(neighbor)) {
                    q.offer(neighbor);
                    mp.put(neighbor, new Node(neighbor.val));
                }

                clone.neighbors.add(mp.get(neighbor));
            }
        }

        return root;
    }
}
