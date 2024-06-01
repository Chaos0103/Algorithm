import java.util.*;

public class Main {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        int result = 0;
        while (!q.isEmpty()) {
            int num = q.poll();
            for (int i = 0; i < graph.get(num).size(); i++) {
                int y = graph.get(num).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(bfs(1));
    }
}