import java.util.ArrayList;
import java.util.List;

class Solution {

    //진행 방향을 나타내는 상수
    private static final int[][] DIRECTION = {{0, 1}, {1, 0}, {-1, -1}};

    public int[] solution(int n) {
        //nxn 배열 생성
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }

        int[][] triangle = new int[n][n];

        int number = 1; //배열에 담길 숫자
        int d = 0; //방향 인덱스
        int x = 0;
        int y = -1;
        while (number <= total) {
            int nx = x + DIRECTION[d % 3][0];
            int ny = y + DIRECTION[d % 3][1];

            if (n <= nx || n <= ny || triangle[ny][nx] > 0) {
                d++;
                continue;
            }

            triangle[ny][nx] = number++;
            x = nx;
            y = ny;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                result.add(triangle[i][j]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}