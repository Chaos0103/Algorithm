import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    //주사위는 지도 위에 윗 면이 1, 동쪽을 바라보는 방향이 3인 상태로 x, y에 놓여있음
    //가장 처음에 주사위 모든 면은 0
    //지도의 각 칸에는 정수가 하나씩 씌여져 있음
    //이동한 칸에 쓰여있는 수가 0이면 주사위 바닥면의 숫자가 복사
    //0이 아닌 경우 칸에 쓰여있는 수가 주사위 바닥으로 복사
    //주사위가 이동할 때 마다 상단에 쓰여있는 값을 출력
    //범위를 벗어나는 명령은 무시, 출력 X
    //1:동, 2: 서, 3: 북, 4: 남
    private static final int[][] directions = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private static void moveDice(int[][] dice, int cmd) {
        if (cmd == 1) {
            int temp = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = dice[1][2];
            dice[1][2] = temp;
        } else if (cmd == 2) {
            for (int i = 0; i < 3; i++) {
                int temp = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = dice[1][2];
                dice[1][2] = temp;
            }
        } else if (cmd == 3) {
            int temp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = temp;
        } else if (cmd == 4) {
            for (int i = 0; i < 3; i++) {
                int temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
            }
        }
    }

    private static void copyValue(int[][] dice, int[][] map, int y, int x) {
        if (map[y][x] == 0) {
            map[y][x] = dice[3][1];
        } else {
            dice[3][1] = map[y][x];
            map[y][x] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        int[][] dice = new int[4][3];
        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int cmd = Integer.parseInt(st.nextToken());
            y += directions[cmd][0];
            x += directions[cmd][1];
            if (!(0 <= y && y < n && 0 <= x && x < m)) {
                y -= directions[cmd][0];
                x -= directions[cmd][1];
                continue;
            }
            moveDice(dice, cmd);
            copyValue(dice, map, y, x);
            sb.append(dice[1][1]).append("\n");
        }

        System.out.println(sb);
    }
}