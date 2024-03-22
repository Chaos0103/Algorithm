import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    //배열 회전
    private static void rotate(int[][] map, int y, int x, int n) {
        int[][] rotateMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotateMap[i][j] = map[y + n - 1 - j][x + i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[y + i][x + j] = rotateMap[i][j];
            }
        }
    }

    //얼음 녹이기
    private static void melt(int[][] map, int n) {
        boolean[][] melt = new boolean[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] > 0 && count(map, y, x, n) < 3) {
                    melt[y][x] = true;
                }
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (melt[y][x]) {
                    map[y][x] -= 1;
                }
            }
        }
    }

    private static int count(int[][] map, int y, int x, int n) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + directions[i][0];
            int nx = x + directions[i][1];

            if (!(0 <= ny && ny < n && 0 <= nx && nx < n)) {
                continue;
            }

            if (map[ny][nx] == 0) {
                continue;
            }

            count++;
        }
        return count;
    }

    private static int bfs(int[][] map, boolean[][] isVisited, int y, int x, int n) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        isVisited[y][x] = true;

        int size = 0;
        while (!q.isEmpty()) {
            Point point = q.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int ny = point.y + directions[i][0];
                int nx = point.x + directions[i][1];

                if (!(0 <= ny && ny < n && 0 <= nx && nx < n)) {
                    continue;
                }

                if (map[ny][nx] == 0 || isVisited[ny][nx]) {
                    continue;
                }

                isVisited[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        n = (int) Math.pow(2, n);

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (q-- > 0) {
            int l = Integer.parseInt(st.nextToken());
            int step = (int) Math.pow(2, l);
            for (int y = 0; y < n; y += step) {
                for (int x = 0; x < n; x += step) {
                    rotate(map, y, x, step);
                }
            }

            melt(map, n);
        }

        int ice = 0;
        int max = 0;
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0 && !isVisited[i][j]) {
                    int size = bfs(map, isVisited, i, j, n);
                    max = Math.max(max, size);
                }
                ice += map[i][j];
            }
        }

        System.out.println(ice);
        System.out.println(max);
    }
}
