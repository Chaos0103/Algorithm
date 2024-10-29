import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] map = new int[101][101];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] p : rectangle) {
            draw(p[1] * 2, p[0] * 2, p[3] * 2, p[2] * 2);
        }

        return bfs(characterY * 2, characterX * 2, itemY * 2, itemX * 2);
    }

    private int bfs(int y, int x, int ty, int tx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x, 0});
        boolean[][] isVisited = new boolean[101][101];
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == ty && p[1] == tx) {
                return p[2] / 2;
            }

            for (int i = 0; i < 4; i++) {
                int ny = p[0] + d[i][0];
                int nx = p[1] + d[i][1];
                if (!(0 <= ny && ny < 101 && 0 <= nx && nx < 101)) {
                    continue;
                }
                if (isVisited[ny][nx] || map[ny][nx] != 2) {
                    continue;
                }
                isVisited[ny][nx] = true;
                q.offer(new int[]{ny, nx, p[2] + 1});
            }
        }
        return 0;
    }

    private void draw(int y1, int x1, int y2, int x2) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                map[i][j] = 1;
                if (i == y1 || i == y2 || j == x1 || j == x2) {
                    map[i][j] = 2;
                }
            }
        }
    }
}