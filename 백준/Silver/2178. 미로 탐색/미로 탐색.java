import java.util.*;

class Node {

    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static int n, m;
    public static int[][] array;

    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];
                if (nx < 0 || n <= nx || ny < 0 || m <= ny) {
                    continue;
                }
                if (array[nx][ny] != 1) {
                    continue;
                }
                array[nx][ny] = array[node.getX()][node.getY()] + 1;
                q.offer(new Node(nx, ny));
            }
        }
        return array[n - 1][m - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split("");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }
}