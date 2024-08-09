import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final Queue<long[]> q = new ArrayDeque<>();
    private static final int[] d = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Long> isVisited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            q.offer(new long[]{x, 0});
            isVisited.add(x);
        }

        long result = 0;
        while (k > 0) {
            long[] data = q.poll();
            long x = data[0];
            long dist = data[1];
            for (int i = 0; i < 2; i++) {
                if (k == 0) {
                    break;
                }
                long nx = x + d[i];

                if (isVisited.contains(nx)) {
                    continue;
                }

                q.offer(new long[]{nx, dist + 1});
                isVisited.add(nx);
                result += dist + 1;
                k--;
            }
        }

        System.out.println(result);
    }
}