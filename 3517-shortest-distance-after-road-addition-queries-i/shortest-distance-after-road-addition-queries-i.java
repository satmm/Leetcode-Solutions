import java.util.*;

public class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            graph.get(u).add(new int[]{v, 1});
            answer[i] = dijkstra(graph, n);
        }
        return answer;
    }

    private int dijkstra(List<List<int[]>> graph, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new int[]{0, 0});
        dist[0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], currDist = curr[1];

            if (currDist > dist[node]) continue;

            for (int[] edge : graph.get(node)) {
                int next = edge[0], weight = edge[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        return dist[n - 1];
    }
}