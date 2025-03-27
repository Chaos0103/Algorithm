import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> upper = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (lower.isEmpty()) {
                lower.offer(v);
            } else if (lower.peek() >= v) {
                if (lower.size() > upper.size()) {
                    upper.offer(lower.poll());
                }
                lower.offer(v);
            } else if (lower.peek() < v && (upper.isEmpty() || v <= upper.peek())) {
                if (lower.size() <= upper.size()) {
                    lower.offer(v);
                } else {
                    upper.offer(v);
                }
            } else if (upper.isEmpty()) {
                upper.offer(v);
            } else if (upper.peek() < v) {
                if (lower.size() <= upper.size()) {
                    lower.offer(upper.poll());
                }
                upper.offer(v);
            }
            System.out.println(lower.peek());
        }
    }
}