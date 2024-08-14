import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //1. 외부(0,0)를 탐색하며 외부와 맞닿은 치즈 검색
    //2. 치즈 녹이기
    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int totalCount = 0;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    totalCount++;
                }
            }
        }

        int time = 0;
        while (totalCount > 0) {
            boolean[][] isMelt = new boolean[n][m];
            int meltCount = findMelt(map, isMelt);

            melt(map, isMelt);

            totalCount -= meltCount;
            time++;
            if (totalCount == 0) {
                System.out.println(time);
                System.out.println(meltCount);
            }
        }
    }

    private static void melt(int[][] map, boolean[][] isMelt) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (isMelt[i][j]) {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int findMelt(int[][] map, boolean[][] isMelt) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0));
        isMelt[0][0] = true;

        int count = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = p.y + d[i][0];
                int nx = p.x + d[i][1];

                if (!(0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length)) {
                    continue;
                }

                if (isMelt[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 1) {
                    count++;
                    isMelt[ny][nx] = true;
                    continue;
                }

                isMelt[ny][nx] = true;
                q.offer(new Point(ny, nx));
            }
        }
        return count;
    }
}