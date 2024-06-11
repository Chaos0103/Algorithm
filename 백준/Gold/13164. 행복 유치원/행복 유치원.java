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
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = heights[i + 1] - heights[i];
        }

        Arrays.sort(diff);

        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += diff[i];
        }
        
        System.out.println(result);
    }
}