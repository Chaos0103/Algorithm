import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int INF = (int) 1e9;
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    private static class Node implements Comparable<Node> {
        public int index;
        public int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }

    private static int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int dist = node.distance;

            if (d[index] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).distance;
                if (d[graph.get(index).get(i).index] > cost) {
                    d[graph.get(index).get(i).index] = cost;
                    pq.add(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }

        return d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, 1));
        }

        int[] distance = dijkstra(x, n);

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            result.forEach(System.out::println);
        }
    }
}