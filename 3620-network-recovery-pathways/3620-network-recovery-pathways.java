import java.util.*;

class Solution {
    private List<int[]>[] graph;
    private int n;
    private long k;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.k = k;
        n = online.length;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int left = Integer.MAX_VALUE;
        int right = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if (!online[u] || !online[v]) continue;

            graph[u].add(new int[]{v, w});
            left = Math.min(left, w);
            right = Math.max(right, w);
        }

        if (left == Integer.MAX_VALUE) return -1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return check(left) ? left : -1;
    }

    private boolean check(int minEdge) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE / 4);
        dist[0] = 0;

        PriorityQueue<long[]> pq =
            new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d > dist[u]) continue;
            if (d > k) return false;
            if (u == n - 1) return true;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];

                if (w < minEdge) continue;

                long nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
        }

        return false;
    }
}