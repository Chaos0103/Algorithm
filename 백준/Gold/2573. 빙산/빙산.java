import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //1. 사방탐색으로 0의 갯수를 카운팅
    //2. 0의 갯수를 뺀 값과 0중 큰 값을 저장
    //3. 모든 좌표의 탐색이 끝나면 DFS로 덩어리 계산
    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int count = 1;
        while (count == 1) {
            int[][] temp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0) {
                        temp[i][j] = counter(map, i, j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = Math.max(0, map[i][j] - temp[i][j]);
                }
            }

            boolean[][] isVisited = new boolean[n][m];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dfs(map, isVisited, i, j)) {
                        count++;
                    }
                }
            }
            time++;
        }

        System.out.println(count == 0 ? 0 : time);
    }

    private static boolean dfs(int[][] map, boolean[][] isVisited, int y, int x) {
        if (!(0 <= y && y < map.length && 0 <= x && x < map[0].length)) {
            return false;
        } else if (map[y][x] > 0) {
            if (isVisited[y][x]) {
                return false;
            }

            isVisited[y][x] = true;
            dfs(map, isVisited, y + 1, x);
            dfs(map, isVisited, y, x + 1);
            dfs(map, isVisited, y - 1, x);
            dfs(map, isVisited, y, x - 1);
            return true;
        }
        return false;
    }

    private static int counter(int[][] map, int y, int x) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if (map[ny][nx] == 0) {
                count++;
            }
        }
        return count;
    }
}