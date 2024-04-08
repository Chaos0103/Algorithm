import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        dp[3] = 1;
        for (int i = 5; i <= n; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        System.out.println(dp[n] >= INF ? -1 : dp[n]);
    }
}