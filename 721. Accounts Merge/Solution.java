class Solution {
    private Map<String, String> parent = new HashMap<>();
    private Map<String, Integer> size = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> ownerMap = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!parent.containsKey(email)) {
                    parent.put(email, email);
                    size.put(email, 1);
                    ownerMap.put(email, account.get(0));
                }
            }
        }

        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                unionFind(account.get(i-1), account.get(i));
            }
        }

        Map<String, Set<String>> pc = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = findParent(email);
            if (!pc.containsKey(root)) {
                pc.put(root, new TreeSet<>());
            }
            pc.get(root).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (var p : pc.entrySet()) {
            List<String> arr = new ArrayList<>();
            arr.add(ownerMap.get(p.getKey()));
            arr.addAll(p.getValue());
            res.add(arr);
        }

        return res;
    }

    private void unionFind(String u, String v) {
        String pu = findParent(u);
        String pv = findParent(v);
        if (pu.equals(pv)) return;

        if (size.get(pu) < size.get(pv)) {
            String tmp = pu;
            pu = pv;
            pv = tmp;
        }

        parent.put(pv, pu);
        size.put(pu, size.get(pv) + size.get(pu));
    }

    private String findParent(String node) {
        if (!node.equals(parent.get(node))) {
            parent.put(node, findParent(parent.get(node)));
        }
        return parent.get(node);
    }
}
