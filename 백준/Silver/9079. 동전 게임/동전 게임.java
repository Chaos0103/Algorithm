import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 풀이 순서
     * 1. 입력 받은 3x3 동전을 2진법 수치화 한다. [000000000(2) ~ 111111111(2)]
     * 2. 큐에 나온 숫자를 삽입한다.
     * 3. 큐가 빌때까지 반복하며 이미 나온 숫자라면 생략한다.
     * 4. 모든 경우의 수를 연산한다.
     */
    private static int[] next(int num) {
        int[] arr = new int[8];
        arr[0] = calc(num, new int[]{0, 1, 2});
        arr[1] = calc(num, new int[]{3, 4, 5});
        arr[2] = calc(num, new int[]{6, 7, 8});
        arr[3] = calc(num, new int[]{0, 3, 6});
        arr[4] = calc(num, new int[]{1, 4, 7});
        arr[5] = calc(num, new int[]{2, 5, 8});
        arr[6] = calc(num, new int[]{0, 4, 8});
        arr[7] = calc(num, new int[]{2, 4, 6});
        return arr;
    }

    private static int calc(int num, int[] indexes) {
        for (int i = 0; i < 3; i++) {
            num = num ^ (1 << indexes[i]);
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String binary = "";
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    String token = st.nextToken();
                    if ("H".equals(token)) {
                        binary += "1";
                    } else {
                        binary += "0";
                    }
                }
            }

            int num = Integer.parseInt(binary, 2);

            int[] isVisited = new int[512];
            boolean isPossible = false;

            Queue<Integer> q = new LinkedList<>();
            q.add(num);
            isVisited[num] = 1;
            while (!q.isEmpty()) {
                int qNum = q.poll();
                if (qNum == 0 || qNum == 511) {
                    isPossible = true;
                    break;
                }
                int[] arr = next(qNum);
                for (int n : arr) {
                    if (isVisited[n] > 0) {
                        continue;
                    }
                    isVisited[n] = isVisited[qNum] + 1;
                    q.add(n);
                }
            }

            if (isPossible) {
                if (isVisited[0] == 0) {
                    System.out.println(isVisited[511] - 1);
                } else if (isVisited[511] == 0) {
                    System.out.println(isVisited[0] - 1);
                } else {
                    System.out.println(Math.min(isVisited[0], isVisited[511]) - 1);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}