class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }

        Map<Integer, Set<Integer>> visit = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            dfs(adjList, visit, i);
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(visit.get(query[0]).contains(query[1]));
        }

        return res;
    }

    private void dfs(List<List<Integer>> adjList, Map<Integer, Set<Integer>> visit, int node) {
        if (visit.containsKey(node)) {
            return;
        }

        visit.put(node, new HashSet<>());
        for (int neighbor : adjList.get(node)) {
            dfs(adjList, visit, neighbor);
            visit.get(node).addAll(visit.get(neighbor));
            visit.get(node).add(neighbor);
        }
    }
}
