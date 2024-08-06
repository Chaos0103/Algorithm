import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int result;

    private static void dfs(int index, boolean[] isVisited, int depth) {
        if (depth == 4) {
            result = 1;
            return;
        }

        isVisited[index] = true;
        for (int i = 0; i < graph.get(index).size(); i++) {
            int next = graph.get(index).get(i);
            if (!isVisited[next]) {
                dfs(next, isVisited, depth + 1);
                isVisited[next] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, new boolean[n], 0);
            if (result == 1) {
                break;
            }
        }

        System.out.println(result);
    }
}