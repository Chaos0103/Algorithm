import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long x = Integer.parseInt(st.nextToken());
                pq.offer(x);
            }

            long result = 0;
            while (pq.size() > 1) {
                long n1 = pq.poll();
                long n2 = pq.poll();

                long sum = n1 + n2;
                result += sum;
                pq.offer(sum);
            }

            System.out.println(result);
        }
    }
}
