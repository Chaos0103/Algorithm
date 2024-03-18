import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final List<Point> cctvPositions = new ArrayList<>();
    private static int result = Integer.MAX_VALUE;

    private static class Point {
        public int y;
        public int x;
        public int type;

        public Point(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    private static int[][] copy(int[][] origin) {
        int[][] copy = new int[origin.length][origin[0].length];
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[0].length; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }

    private static void check(int[][] office, Point cctvPosition, int direction) {
        int x = cctvPosition.x;
        int y = cctvPosition.y;
        while (0 <= y && y < office.length && 0 <= x && x < office[0].length) {
            if (office[y][x] == 6) {
                break;
            }
            office[y][x] = cctvPosition.type;
            y += d[direction][0];
            x += d[direction][1];
        }
    }

    private static void dfs(int[][] office, int depth) {
        if (depth == cctvPositions.size()) {
            int count = 0;
            for (int i = 0; i < office.length; i++) {
                for (int j = 0; j < office[0].length; j++) {
                    if (office[i][j] == 0) {
                        count++;
                    }
                }
            }
            result = Math.min(result, count);
            return;
        }

        Point cctvPosition = cctvPositions.get(depth);
        for (int i = 0; i < 4; i++) {
            int[][] copyOffice = copy(office);
            if (cctvPosition.type == 1) {
                check(copyOffice, cctvPosition, i);
            } else if (cctvPosition.type == 2) {
                check(copyOffice, cctvPosition, i);
                check(copyOffice, cctvPosition, (i + 2) % 4);
            } else if (cctvPosition.type == 3) {
                check(copyOffice, cctvPosition, i);
                check(copyOffice, cctvPosition, (i + 1) % 4);
            } else if (cctvPosition.type == 4) {
                check(copyOffice, cctvPosition, i);
                check(copyOffice, cctvPosition, (i + 1) % 4);
                check(copyOffice, cctvPosition, (i + 2) % 4);
            } else if (cctvPosition.type == 5) {
                check(copyOffice, cctvPosition, i);
                check(copyOffice, cctvPosition, (i + 1) % 4);
                check(copyOffice, cctvPosition, (i + 2) % 4);
                check(copyOffice, cctvPosition, (i + 3) % 4);
            }
            dfs(copyOffice, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] office = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                office[y][x] = Integer.parseInt(st.nextToken());
                //cctv point
                if (1 <= office[y][x] && office[y][x] <= 5) {
                    cctvPositions.add(new Point(y, x, office[y][x]));
                }
            }
        }

        dfs(office, 0);
        System.out.println(result);
    }
}