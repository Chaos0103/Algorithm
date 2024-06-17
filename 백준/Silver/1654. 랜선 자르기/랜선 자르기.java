import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long right = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        long left = 1;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            int count = 0;
            for (int length : arr) {
                count += (length / mid);
            }

            if (count < n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = Math.max(result, mid);
            }
        }

        System.out.println(result);
    }
}