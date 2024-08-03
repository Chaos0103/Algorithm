import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            pq.offer(x);
        }

        int result = 0;
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();

            int sum = n1 + n2;
            result += sum;
            pq.offer(sum);
        }

        System.out.println(result);
    }
}

