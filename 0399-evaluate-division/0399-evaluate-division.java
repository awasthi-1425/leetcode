class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());

            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
            } else if (src.equals(dest)) {
                ans[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                ans[i] = dfs(src, dest, 1.0, visited, graph);
            }
        }

        return ans;
    }

    private double dfs(String curr, String target, double product,
                       Set<String> visited,
                       Map<String, Map<String, Double>> graph) {

        if (curr.equals(target)) {
            return product;
        }

        visited.add(curr);

        for (Map.Entry<String, Double> entry : graph.get(curr).entrySet()) {
            String next = entry.getKey();

            if (!visited.contains(next)) {
                double res = dfs(next, target,
                        product * entry.getValue(),
                        visited, graph);

                if (res != -1.0) {
                    return res;
                }
            }
        }

        return -1.0;
    }
}