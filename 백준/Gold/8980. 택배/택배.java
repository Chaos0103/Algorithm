import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{s, e, b};
        }

        Arrays.sort(arr, (o1, o2) -> {
            if ((o1[1] - o1[0]) == (o2[1] - o2[0])) {
                if (o1[0] == o2[0]) {
                    return o2[2] - o1[2];
                }
                return o1[0] - o2[0];
            }
            return (o1[1] - o1[0]) - (o2[1] - o2[0]);
        });

        int sum = 0;
        int[] boxes = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int s = arr[i][0];
            int e = arr[i][1];
            int b = arr[i][2];
            int max = findMaxBoxBetween(boxes, s, e);
            //담을 수 없을 때
            if (max >= c) {
                continue;
            }

            //일부만 담을 때
            int limit = c - max;
            b = Math.min(b, limit);

            //전체 담을 때
            for (int j = s; j < e; j++) {
                boxes[j] += b;
            }
            sum += b;
        }

        System.out.println(sum);
    }

    private static int findMaxBoxBetween(int[] boxes, int start, int end) {
        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(max, boxes[i]);
        }
        return max;
    }
}
