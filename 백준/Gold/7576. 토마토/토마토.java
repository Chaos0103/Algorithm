import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static class Tomato {
        public int x;
        public int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int[][] map, int n, int m, List<Tomato> tomatoes) {
        Queue<Tomato> q = new LinkedList<>(tomatoes);

        while (!q.isEmpty()) {
            Tomato tomato = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + d[i][0];
                int ny = tomato.y + d[i][1];

                if (!(0 <= nx && nx < m && 0 <= ny && ny < n)) {
                    continue;
                }

                if (map[ny][nx] != 0) {
                    continue;
                }

                map[ny][nx] = map[tomato.y][tomato.x] + 1;
                q.add(new Tomato(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        List<Tomato> tomatoes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    tomatoes.add(new Tomato(j, i));
                }
            }
        }

        bfs(map, n, m, tomatoes);

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        System.out.println(result - 1);
    }
}