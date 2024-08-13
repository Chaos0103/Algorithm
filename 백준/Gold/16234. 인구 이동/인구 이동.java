import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //L <= 두 나라 인구 차이 <= R
    //열려야 하는 국격선이 모두 열리면, 인구 이동 시작
    //연합을 이루면 [연합 인구 수/연합 칸 수] 소수점 생략
    //인구 이동이 몇일동안 발생하는지 출력
    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int n,l, r;

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

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            int index = 1;
            int[][] area = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (area[i][j] == 0) {
                        bfs(map, i, j, area, index);
                        index++;
                    }
                }
            }

            if (index - 1 == n * n) {
                break;
            }

            int[][] calc = new int[index][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = area[i][j];
                    calc[num][0] += map[i][j];
                    calc[num][1] += 1;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = area[i][j];
                    map[i][j] = calc[num][0] / calc[num][1];
                }
            }
            result++;

            if (index == 2) {
                break;
            }
        }
        System.out.println(result);
    }

    private static void bfs(int[][] map, int y, int x, int[][] area, int index) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(y, x));
        area[y][x] = index;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + d[i][0];
                int nx = p.x + d[i][1];

                if (!(0 <= ny && ny < n && 0 <= nx && nx < n)) {
                    continue;
                }

                if (area[ny][nx] > 0) {
                    continue;
                }

                if (!(l <= Math.abs(map[p.y][p.x] - map[ny][nx]) && Math.abs(map[p.y][p.x] - map[ny][nx]) <= r)) {
                    continue;
                }

                area[ny][nx] = index;
                q.offer(new Point(ny, nx));
            }
        }
    }
}