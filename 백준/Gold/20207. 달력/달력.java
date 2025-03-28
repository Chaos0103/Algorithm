import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return (b[1] - b[0]) - (a[1] - a[0]);
            }
            return a[0] - b[0];
        });

        int[] days = new int[366];
        for (int i = 0; i < n; i++) {
            for (int j = arr[i][0]; j <= arr[i][1]; j++) {
                days[j]++;
            }
        }

        int result = 0;
        int weight = 0;
        int height = 0;
        for (int i = 1; i <= 365; i++) {
            if (days[i] != 0) {
                height = Math.max(height, days[i]);
                weight++;
            } else {
                result += height * weight;
                height = 0;
                weight = 0;
            }
        }

        result += height * weight;

        System.out.println(result);
    }
}