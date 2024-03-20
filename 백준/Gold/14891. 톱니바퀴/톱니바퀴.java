import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] indexes;

    //톱니바퀴 단일 회전
    private static void rotate(int standard, int direction) {
        indexes[standard] = ((indexes[standard] + direction) + 8) % 8;
    }

    //톱니바퀴 회전 여부
    private static int[] getIsRotate(int[][] wheels, int standard, int direction) {
        int[] rotation = new int[4];
        rotation[standard] = direction;

        //왼쪽 확인
        for (int i = standard - 1; i >= 0; i--) {
            if (wheels[i + 1][(6 + indexes[i + 1]) % 8] == wheels[i][(2 + indexes[i]) % 8]) {
                break;
            }
            rotation[i] = rotation[i + 1] * -1;
        }

        //오른쪽 확인
        for (int i = standard + 1; i < 4; i++) {
            if (wheels[i][(6 + indexes[i]) % 8] == wheels[i - 1][(2 + indexes[i - 1]) % 8]) {
                break;
            }
            rotation[i] = rotation[i - 1] * -1;
        }

        return rotation;
    }

    //점수 합산 반환
    private static int getScore(int[][] wheels) {
        int totalScore = 0;
        int score = 1;
        for (int i = 0; i < 4; i++) {
            totalScore += wheels[i][indexes[i]] * score;
            score *= 2;
        }
        return totalScore;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] wheels = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = line.charAt(j) - '0';
            }
        }

        indexes = new int[4];
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken()) * -1;

            //톱니바퀴 회전 여부 구하기
            int[] isRotate = getIsRotate(wheels, index, direction);

            //톱니바퀴 회전 여부를 순회하며 회전 시키기
            for (int i = 0; i < 4; i++) {
                rotate(i, isRotate[i]);
            }
        }
        //점수의 합산을 구한다.
        int score = getScore(wheels);
        System.out.println(score);
    }

}

//총 8개의 톱니를 가지고 있는 4개의 톱니바퀴가 존재
//톱니는 N, S극 중 하나
//톱니를 총 K번 회전, 시계방향 or 반시계방향
//톱니끼리 맞닿은 극이 다르면 반대 방향으로 회전
//같으면 유지