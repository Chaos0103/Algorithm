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

    private static class Node implements Comparable<Node> {
        public int index;
        public int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    private static int dijkstra(int start, int end, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int cost = node.cost;

            if (d[index] < cost) {
                continue;
            }

            for (int i = 0; i < graph.get(index).size(); i++) {
                int c = node.cost + graph.get(index).get(i).cost;
                if (d[graph.get(index).get(i).index] > c) {
                    d[graph.get(index).get(i).index] = c;
                    pq.add(new Node(graph.get(index).get(i).index, c));
                }
            }
        }

        return d[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = dijkstra(start, end, n);

        System.out.println(result);
    }
}