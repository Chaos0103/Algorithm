import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long right = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            right = Math.min(right, arr[i]);
        }

        right *= m;
        long left = 0;
        long result = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (long time : arr) {
                count += (mid / time);
            }

            if (count < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = Math.min(result, mid);
            }
        }

        System.out.println(result);
    }
}