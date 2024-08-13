import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<List<Node>> graph = new ArrayList<>();
    private static int result;

    private static class Node {
        public int no;
        public int cost;

        public Node(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        result = 0;
        for (int i = 1; i <= n; i++) {
            if (graph.get(i).size() == 1) {
                boolean[] isVisited = new boolean[n + 1];
                isVisited[i] = true;
                dfs(i, isVisited, 0);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int index, boolean[] isVisited, int cost) {
        result = Math.max(result, cost);

        for (int i = 0; i < graph.get(index).size(); i++) {
            Node node = graph.get(index).get(i);
            if (!isVisited[node.no]) {
                isVisited[node.no] = true;
                dfs(node.no, isVisited, cost + node.cost);
                isVisited[node.no] = false;
            }
        }
    }
}