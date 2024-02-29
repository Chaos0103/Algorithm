import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = (int) 1e9;
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static final int[] d = new int[20001];

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

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int distance = node.distance;

            if (d[index] < distance) {
                continue;
            }

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).distance;
                if (cost < d[graph.get(index).get(i).index]) {
                    d[graph.get(index).get(i).index] = cost;
                    pq.add(new Node(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <= v; i++) {
            System.out.println(d[i] == INF ? "INF" : d[i]);
        }
    }
}