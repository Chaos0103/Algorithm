import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int[] count = new int[100001];
        int flag = 0;
        int size = 0;
        while (right < n) {
            if (flag == 0) {
                count[arr[right]]++;
                if (count[arr[right]] > k) {
                    flag++;
                }
                right++;
            } else {
                count[arr[left]]--;
                if (count[arr[left]] == k) {
                    flag--;
                }
                left++;
            }

            if (flag == 0) {
                size = Math.max(size, right - left);
            }
        }

        System.out.println(size);
    }
}