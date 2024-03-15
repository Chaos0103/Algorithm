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

    private static void dijkstra(int[] d) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int index = node.index;
            int distance = node.distance;

            if (d[index] < distance) {
                continue;
            }

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = distance + graph.get(index).get(i).distance;
                if (d[graph.get(index).get(i).index] > cost) {
                    d[graph.get(index).get(i).index] = cost;
                    q.add(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int[] d = new int[n + 1];
        Arrays.fill(d, INF);

        dijkstra(d);

        System.out.println(d[n]);
    }
}