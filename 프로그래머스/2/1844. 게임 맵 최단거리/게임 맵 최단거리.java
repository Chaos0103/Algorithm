import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];

                if (!(0 <= nx && nx < m && 0 <= ny && ny < n)) {
                    continue;
                }

                if (maps[ny][nx] != 1) {
                    continue;
                }

                maps[ny][nx] = maps[y][x] + 1;
                q.add(new Point(nx, ny));
            }
        }

        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}