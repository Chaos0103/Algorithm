import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            //꿀통이 오른쪽
            int right = (sum[n - 1] - sum[0] - arr[i]) + (sum[n - 1] - sum[i]);
            max = Math.max(max, right);

            //꿀통이 가운데
            int mid = (sum[i] - sum[0]) + (sum[n - 1] - sum[i] - arr[n - 1] + arr[i]);
            max = Math.max(max, mid);

            //꿀통이 왼쪽
            int left = (sum[n - 1] - arr[n - 1] - arr[i]) + (sum[i] - arr[i]);
            max = Math.max(max, left);
        }

        System.out.println(max);
    }
}