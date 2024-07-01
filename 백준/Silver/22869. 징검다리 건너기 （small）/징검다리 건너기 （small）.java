import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static void dfs(int[] arr, boolean[] dp, int n, int k, int depth) {
        if (depth == n - 1) {
            dp[depth] = true;
            return;
        }

        if (dp[depth]) {
            return;
        }

        dp[depth] = true;
        for (int i = depth + 1; i < n; i++) {
            if ((i - depth) * (1 + Math.abs(arr[i] - arr[depth])) <= k) {
                dfs(arr, dp, n, k, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dp = new boolean[n];
        dfs(arr, dp, n, k, 0);

        System.out.println(dp[n - 1] ? "YES" : "NO");
    }
}