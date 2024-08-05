import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Point {
        public int y;
        public int x;
        public int count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int distance = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    distance = (n - 1 - i) + (m - 1 - j);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 0));
        boolean[][] isVisited = new boolean[n][m];
        isVisited[0][0] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == n - 1 && p.x == m - 1) {
                result = Math.min(result, p.count);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = p.y + d[i][0];
                int nx = p.x + d[i][1];
                if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                    continue;
                }

                if (map[ny][nx] == 1 || isVisited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 2) {
                    result = Math.min(result, p.count + 1 + distance);
                }

                isVisited[ny][nx] = true;
                q.offer(new Point(ny, nx, p.count + 1));
            }
        }

        System.out.println(result > t ? "Fail" : result);
    }
}