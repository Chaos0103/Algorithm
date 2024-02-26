import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static int n;
    private static final List<List<Integer>> comb = new ArrayList<>();

    private static void comb(int[] arr, boolean[] visited, int start, int depth) {
        if (depth == n / 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    temp.add(i);
                }
            }
            comb.add(temp);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(arr, visited, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] abilityValues = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                abilityValues[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arr = IntStream.range(0, n).toArray();
        comb(arr, new boolean[n], 0, 0);

        int result = Integer.MAX_VALUE;
        for (List<Integer> data : comb) {
            int startTeam = 0;
            int linkTeam = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (data.contains(i) && data.contains(j)) {
                        startTeam += abilityValues[i][j];
                    } else if (!data.contains(i) && !data.contains(j)) {
                        linkTeam += abilityValues[i][j];
                    }
                }
            }
            result = Math.min(result, Math.abs(startTeam - linkTeam));
        }

        System.out.println(result);
    }
}
