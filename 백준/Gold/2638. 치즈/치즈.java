import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    private static final int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean[][] getOutArea(int[][] map) {
        boolean[][] area = new boolean[map.length][map[0].length];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = point.y + d[i][0];
                int nx = point.x + d[i][1];

                if (!(0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length)) {
                    continue;
                }

                if (map[ny][nx] == 1) {
                    continue;
                }

                if (area[ny][nx]) {
                    continue;
                }

                area[ny][nx] = true;
                q.add(new Point(nx, ny));
            }
        }

        return area;
    }

    private static boolean isCheck(int[][] map, boolean[][] outArea, int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if (!(0 <= ny && ny < map.length && 0 <= nx && nx < map[0].length)) {
                continue;
            }

            if (outArea[ny][nx]) {
                count++;
            }
        }

        return count >= 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cheeseCount = 0;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        int result = 0;
        while (cheeseCount > 0) {
            boolean[][] outArea = getOutArea(map);
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[y][x] == 1 && isCheck(map, outArea, x, y)) {
                        cheeseCount--;
                        map[y][x] = 0;
                    }
                }
            }
            result++;
        }

        System.out.println(result);
    }
}