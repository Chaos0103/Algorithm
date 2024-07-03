import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
            if (arr[i - 1] > arr[i]) {
                sum[i] += sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int start, end;
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            start = Integer.parseInt(s1[0]);
            end = Integer.parseInt(s1[1]);
            sb.append(sum[end] - sum[start]).append("\n");
        }
        System.out.println(sb);
    }
}