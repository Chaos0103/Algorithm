import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            } else {
                int index = binarySearch(lis, arr[i]);
                lis.set(index, arr[i]);
            }
        }

        System.out.println(lis.size());
    }

    private static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}