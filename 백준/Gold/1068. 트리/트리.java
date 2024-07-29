import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int result;

    private static void dfs(int node, int remove) {
        if (graph.get(node).isEmpty()) {
            result++;
            return;
        }

        for (int i = 0; i < graph.get(node).size(); i++) {
            if (graph.get(node).get(i) == remove) {
                if (graph.get(node).size() == 1) {
                    result++;
                }
                continue;
            }
            dfs(graph.get(node).get(i), remove);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int i = 0; i < n; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) {
                root = i;
                continue;
            }
            graph.get(node).add(i);
        }
//        System.out.println(graph);
        int remove = Integer.parseInt(br.readLine());

        if (root == remove) {
            System.out.println(0);
            return;
        }

        result = 0;
        dfs(root, remove);
        System.out.println(result);
    }
}