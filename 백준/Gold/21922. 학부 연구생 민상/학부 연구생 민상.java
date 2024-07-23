import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int[][] items = {
        {0, 1, 2, 3},
        {0, -1, 2, -1},
        {-1, 1, -1, 3},
        {1, 0, 3, 2},
        {3, 2, 1, 0}
    };

    private static class Point {
        public int y;
        public int x;
        public int d;

        public Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        List<Point> airs = new ArrayList<>();
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 9) {
                    airs.add(new Point(y, x, 0));
                }
            }
        }

        boolean[][] isVisited = new boolean[n][m];

        for (Point air : airs) {
            Queue<Point> q = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                q.add(new Point(air.y, air.x, i));
            }
            isVisited[air.y][air.x] = true;

            while (!q.isEmpty()) {
                Point p = q.poll();
                int ny = p.y + d[p.d][0];
                int nx = p.x + d[p.d][1];

                if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                    continue;
                }

                if (map[ny][nx] == 9) {
                    continue;
                }
                
                isVisited[ny][nx] = true;
                int nd = items[map[ny][nx]][p.d];
                if (nd == -1) {
                    continue;
                }

                q.add(new Point(ny, nx, nd));
            }
        }

        int result = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (isVisited[y][x]) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}