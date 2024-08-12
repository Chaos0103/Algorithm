import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Point> q = new ArrayDeque<>();
    private static int n, m, h, w;
    private static int[][] map;

    private static class Point {
        public int y;
        public int x;
        public int c;

        public Point(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }

        public boolean up() {
            int ny = y - 1;
            for (int nx = x; nx < x + w; nx++) {
                if (isOutOfRange(ny, nx)) {
                    return false;
                }
                if (map[ny][nx] == 1) {
                    return false;
                }
            }
            return true;
        }

        public boolean down() {
            int ny = y + h;
            for (int nx = x; nx < x + w; nx++) {
                if (isOutOfRange(ny, nx)) {
                    return false;
                }
                if (map[ny][nx] == 1) {
                    return false;
                }
            }
            return true;
        }

        public boolean left() {
            int nx = x - 1;
            for (int ny = y; ny < y + h; ny++) {
                if (isOutOfRange(ny, nx)) {
                    return false;
                }
                if (map[ny][nx] == 1) {
                    return false;
                }
            }
            return true;
        }

        public boolean right() {
            int nx = x + w;
            for (int ny = y; ny < y + h; ny++) {
                if (isOutOfRange(ny, nx)) {
                    return false;
                }
                if (map[ny][nx] == 1) {
                    return false;
                }
            }
            return true;
        }

        private boolean isOutOfRange(int ny, int nx) {
            return !(0 <= ny && ny < n && 0 <= nx && nx < m);
        }

        @Override
        public String toString() {
            return "Point{" +
                "y=" + y +
                ", x=" + x +
                ", c=" + c +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken()) - 1;
        int sx = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;
        int ex = Integer.parseInt(st.nextToken()) - 1;
        q.offer(new Point(sy, sx, 0));

        boolean[][] isVisited = new boolean[n][m];
        isVisited[sy][sx] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == ey && p.x == ex) {
                System.out.println(p.c);
                return;
            }
            if (p.up() && !isVisited[p.y - 1][p.x]) {
                isVisited[p.y - 1][p.x] = true;
                q.offer(new Point(p.y - 1, p.x, p.c + 1));
            }

            if (p.down() && !isVisited[p.y + 1][p.x]) {
                isVisited[p.y + 1][p.x] = true;
                q.offer(new Point(p.y + 1, p.x, p.c + 1));
            }

            if (p.left() && !isVisited[p.y][p.x - 1]) {
                isVisited[p.y][p.x - 1] = true;
                q.offer(new Point(p.y, p.x - 1, p.c + 1));
            }

            if (p.right() && !isVisited[p.y][p.x + 1]) {
                isVisited[p.y][p.x + 1] = true;
                q.offer(new Point(p.y, p.x + 1, p.c + 1));
            }
        }

        System.out.println(-1);
    }
}