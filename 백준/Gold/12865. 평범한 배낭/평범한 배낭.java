import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] bag = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int k = 1; k < K + 1; k++) {
                int itemWeight = bag[i][0];
                if (itemWeight > k)
                    dp[i][k] = dp[i - 1][k];
                else {
                    dp[i][k] = Math.max(dp[i - 1][k], bag[i][1] + dp[i - 1][k - itemWeight]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}