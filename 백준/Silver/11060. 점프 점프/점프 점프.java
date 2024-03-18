import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int index = q.poll();
            for (int i = 1; i <= arr[index]; i++) {
                if (index + i >= n) {
                    continue;
                }

                if (dp[index + i] > dp[index] + 1) {
                    dp[index + i] = dp[index] + 1;
                    q.add(index + i);
                }
            }
        }
        System.out.println(dp[n - 1] == INF ? -1 : dp[n - 1]);
    }
}