import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;

    private static void dfs(int[][] map, int y, int x, int index) {
        if (0 <= y && y < n && 0 <= x && x < m && map[y][x] == -1) {
            map[y][x] = index;
            dfs(map, y + 1, x, index);
            dfs(map, y - 1, x, index);
            dfs(map, y, x + 1, index);
            dfs(map, y, x - 1, index);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y - 1][x - 1] = -1;
        }

        int index = 1;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == -1) {
                    dfs(map, y, x, index++);
                }
            }
        }

        int result = 0;
        for (int i = 1; i < index; i++) {
            int count = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (map[y][x] == i) {
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}