import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] d = {{0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};

    private static class Point {
        public int z;
        public int y;
        public int x;
        public int count;

        public Point(int z, int y, int x, int count) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    private static int bfs(char[][][] map, boolean[][][] isVisited, Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        isVisited[start.z][start.y][start.x] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (map[point.z][point.y][point.x] == 'E') {
                return point.count;
            }

            for (int i = 0; i < 6; i++) {
                int nz = point.z + d[i][0];
                int ny = point.y + d[i][1];
                int nx = point.x + d[i][2];

                if (!(0 <= nz && nz < map.length && 0 <= ny && ny < map[0].length && 0 <= nx && nx < map[0][0].length)) {
                    continue;
                }

                if (map[nz][ny][nx] == '#') {
                    continue;
                }

                if (isVisited[nz][ny][nx]) {
                    continue;
                }

                isVisited[nz][ny][nx] = true;
                q.add(new Point(nz, ny, nx, point.count + 1));
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            Point start = null;
            char[][][] map = new char[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = line.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start = new Point(i, j, k, 0);
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(map, new boolean[l][r][c], start);
            if (result == -1) {
                sb.append("Trapped!");
            } else {
                sb.append(String.format("Escaped in %d minute(s).", result));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}