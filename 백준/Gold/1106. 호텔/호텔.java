import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 101];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for (int j = count; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - count] + cost);
            }
        }

        int result = INF;
        for (int i = c; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}