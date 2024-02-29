import java.io.*;
import java.util.Arrays;
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

        Arrays.sort(arr);

        int[] result = {arr[0], arr[n - 1]};
        int min = Math.abs(arr[n - 1] + arr[0]);
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                result = new int[]{arr[left], arr[right]};
                break;
            } else if (sum > 0) {
                if (min > Math.abs(sum)) {
                    result = new int[]{arr[left], arr[right]};
                    min = Math.abs(sum);
                }
                right--;
            } else {
                if (min > Math.abs(sum)) {
                    result = new int[]{arr[left], arr[right]};
                    min = Math.abs(sum);
                }
                left++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}