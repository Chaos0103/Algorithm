import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][][] d = {
        {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, -1}}, //y: 짝수
        {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {1, 1}} //y: 홀수
    };

    private static class Point {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 2][m + 2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isVisited = new boolean[n + 2][m + 2];
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0));
        isVisited[0][0] = true;

        int count = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 6; i++) {
                int ny = p.y + d[p.y % 2][i][0];
                int nx = p.x + d[p.y % 2][i][1];

                if (!(0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length)) {
                    continue;
                }

                if (isVisited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 1) {
                    count++;
                } else {
                    q.offer(new Point(ny, nx));
                    isVisited[ny][nx] = true;
                }
            }
        }

        System.out.println(count);
    }
}