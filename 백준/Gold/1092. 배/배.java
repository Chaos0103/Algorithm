import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> limits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            limits.add(Integer.parseInt(st.nextToken()));
        }
        limits.sort(Comparator.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            weights.add(Integer.parseInt(st.nextToken()));
        }
        weights.sort(Comparator.reverseOrder());

        if (limits.get(0) < weights.get(0)) {
            System.out.println(-1);
            return;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int limitIndex = 0;
        int weightIndex = 0;
        int result = 0;
        while (weightIndex < weights.size()) {
            int weight = weights.get(weightIndex);
            if (!q.isEmpty() && q.peek() >= weight) {
                q.poll();
                weightIndex++;
                continue;
            }

            int limit = limits.get(limitIndex % n);
            if (limit < weight) { //못드는 경우
                q.offer(limit);
                limitIndex++;
                continue;
            }

            if (limitIndex % n == 0) {
                result++;
            }

            limitIndex++;
            weightIndex++;
        }

        System.out.println(result);
    }
}