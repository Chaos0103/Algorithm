import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] tower = new int[n];
        for (int i = 0; i < n; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        for (int start = 1; start <= 1000; start++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (tower[i] != (start + (k * i))) {
                    count++;
                }
            }
            result = Math.min(result, count);
        }

        System.out.println(result);
    }
}