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

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (left < n) {
            if (right - left == k) {
                int size = map.size();
                if (!map.containsKey(c)) {
                    size++;
                }
                max = Math.max(max, size);
                int remove = arr[left];
                int count = map.get(remove);
                if (count == 1) {
                    map.remove(remove);
                } else {
                    map.put(remove, count - 1);
                }
                left++;
            }

            int num = arr[right];
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
            right++;
        }

        System.out.println(max);
    }
}