import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new HashSet<>();
        int[] count = new int[d + 1];
        int result = 0;
        int left = 0;
        int right = 0;
        while (left < n) {
            if (right - left == k) {
                int size = set.size();
                if (count[c] == 0) {
                    size++;
                }
                result = Math.max(result, size);

                int leftNum = arr[left % n];
                count[leftNum]--;
                if (count[leftNum] == 0) {
                    set.remove(leftNum);
                }
                left++;
            }

            int rightNum = arr[right % n];
            count[rightNum]++;
            set.add(rightNum);
            right++;
        }

        System.out.println(result);
    }
}