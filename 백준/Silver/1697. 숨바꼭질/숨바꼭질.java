import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        public int x;
        public int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }

        public int[] getNextPosition() {
            return new int[]{x + 1, x - 1, x * 2};
        }
    }

    public static int bfs(int start, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        boolean[] isVisited = new boolean[100001];
        int result = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == target) {
                result = node.time;
                break;
            }

            int[] nextPosition = node.getNextPosition();
            for (int next : nextPosition) {
                if (next < 0 || 100000 < next) {
                    continue;
                }
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    q.add(new Node(next, node.time + 1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = bfs(n, k);

        System.out.println(result);
    }
}