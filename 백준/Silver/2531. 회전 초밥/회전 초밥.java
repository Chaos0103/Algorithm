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

        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[i + n] = arr[i];
        }

        Set<Integer> set = new HashSet<>();
        int[] count = new int[d + 1];
        int max = 0;
        int left = 0;
        int right = 0;
        while (left < n) {
            if (right - left == k) {
                int size = set.size();
                if (count[c] == 0) {
                    size++;
                }
                max = Math.max(max, size);

                int remove = arr[left];
                count[remove]--;
                if (count[remove] == 0) {
                    set.remove(remove);
                }
                left++;
            }

            int num = arr[right];
            count[num]++;
            set.add(num);
            right++;
        }

        System.out.println(max);
    }
}