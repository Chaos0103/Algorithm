import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Point> jihun = new ArrayDeque<>();
    private static final Queue<Point> fire = new ArrayDeque<>();
    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Point{" +
                "y=" + y +
                ", x=" + x +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] isVisited = new boolean[n][m];
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    jihun.offer(new Point(i, j));
                    isVisited[i][j] = true;
                    map[i][j] = '.';
                } else if (map[i][j] == 'F') {
                    fire.offer(new Point(i, j));
                }
            }
        }


        int time = 0;
        while (!jihun.isEmpty()) {
            time++;
            int size = fire.size();
            while (size-- > 0) {
                Point fp = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = fp.y + d[i][0];
                    int nx = fp.x + d[i][1];

                    if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                        continue;
                    }

                    if (map[ny][nx] != '.') {
                        continue;
                    }

                    map[ny][nx] = 'F';
                    fire.offer(new Point(ny, nx));
                }
            }

            int jSize = jihun.size();
            while (jSize-- > 0) {
                Point jp = jihun.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = jp.y + d[i][0];
                    int nx = jp.x + d[i][1];

                    if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                        System.out.println(time);
                        return;
                    }

                    if (map[ny][nx] != '.') {
                        continue;
                    }

                    if (isVisited[ny][nx]) {
                        continue;
                    }

                    isVisited[ny][nx] = true;
                    jihun.offer(new Point(ny, nx));
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}