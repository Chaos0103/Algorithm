import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] d = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int result;

    private static class Point {
        public int y;
        public int x;

        private Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void dfs(List<Point> points, int[][] map, boolean[][] isVisited, int index, int depth, int price) {
        if (depth == 3) {
            result = Math.min(result, price);
            return;
        }

        for (int i = index; i < points.size(); i++) {
            Point point = points.get(i);
            if (isValid(isVisited, point.y, point.x)) {
                int p = modify(map, isVisited, point.y, point.x, true);
                dfs(points, map, isVisited, i, depth + 1, price + p);
                modify(map, isVisited, point.y, point.x, false);
            }
        }
    }

    private static boolean isValid(boolean[][] isVisited, int y, int x) {
        for (int i = 0; i < d.length; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];
            if (isVisited[ny][nx]) {
                return false;
            }
        }
        return true;
    }

    private static int modify(int[][] map, boolean[][] isVisited, int y, int x, boolean status) {
        int price = 0;
        for (int i = 0; i < d.length; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];
            isVisited[ny][nx] = status;
            price += map[ny][nx];
        }
        return price;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Point> points = new ArrayList<>();
        for (int y = 1; y < n - 1; y++) {
            for (int x = 1; x < n - 1; x++) {
                points.add(new Point(y, x));
            }
        }

        result = Integer.MAX_VALUE;
        dfs(points, map, new boolean[n][n], 0, 0, 0);

        System.out.println(result);
    }
}