import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }

        while (true) {
            Set<Integer> temp = new HashSet<>();
            for (int i : set) {
                temp.add(arr[i]);
            }

            if (temp.containsAll(set)) {
                break;
            }

            set = temp;
        }

        System.out.println(set.size());
        set.stream()
            .sorted()
            .forEach(System.out::println);
    }
}