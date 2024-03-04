import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static boolean isValid(int number, Set<Integer> set) {
        //
        if (number == 0 && set.contains(number)) {
            return false;
        }

        while (number > 0) {
            if (set.contains(number % 10)) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }

        int left = n;
        int right = n;
        while (!isValid(left, set) && !isValid(right, set)) {
            left = Math.max(left - 1, 0);
            //
            if (right > 1000000) {
                break;
            }
            right++;
        }
        int[] count = new int[3];
        Arrays.fill(count, Integer.MAX_VALUE);

        if (isValid(left, set)) {
            count[0] = (n - left) + Integer.toString(left).length();
        }

        if (isValid(right, set)) {
            count[1] = (right - n) + Integer.toString(right).length();
        }

        count[2] = Math.abs(n - 100);

        Arrays.sort(count);

        System.out.println(count[0]);
    }
}
