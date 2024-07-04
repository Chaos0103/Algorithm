import java.io.*;
import java.util.*;

public class Main {
    private static int[] solution(int[] visit, int term) {
        if (visit.length < term) {
            return new int[]{0, 0};
        }

        int maxVisit = 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        while (right < visit.length) {
            if (right - left == term) {
                if (maxVisit == sum) {
                    count++;
                } else if (maxVisit < sum) {
                    maxVisit = sum;
                    count = 1;
                }
            } else if (right - left < term) {
                sum += visit[right];
                right++;
                continue;
            }
            sum -= visit[left++];
        }

        if (maxVisit == sum) {
            count++;
        } else if (maxVisit < sum) {
            maxVisit = sum;
            count = 1;
        }

        return new int[]{maxVisit, count};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] solution = solution(arr, x);
        if (solution[0] == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(solution[0]);
            System.out.println(solution[1]);
        }
    }
}