import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            run(n, arr);
        }
    }

    private static void run(int n, int[][] arr) {
        int[][] dp = new int[2][n + 1];
        dp[0][1] = arr[0][1];
        dp[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
        }

        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }
}