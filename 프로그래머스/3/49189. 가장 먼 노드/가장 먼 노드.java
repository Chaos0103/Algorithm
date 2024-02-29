import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static final int INF = (int) 1e9;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] d = new int[100001];

    private static class Node implements Comparable<Node> {
        public int index;
        public int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        //거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }

    private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;
            if (d[now] < dist) {
                continue;
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                if (cost < d[graph.get(now).get(i).index]) {
                    d[graph.get(now).get(i).index] = cost;
                    pq.offer(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        for (int i = 0; i <= n; i++) {

            graph.add(new ArrayList<>());
        }

        for (int[] arr : edge) {
            graph.get(arr[0]).add(new Node(arr[1], 1));
            graph.get(arr[1]).add(new Node(arr[0], 1));
        }

        Arrays.fill(d, INF);

        dijkstra(1);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, d[i]);
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] == max) {
                result++;
            }
        }

        return result;
    }
}