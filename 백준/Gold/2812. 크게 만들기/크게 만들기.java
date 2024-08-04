import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char num = str.charAt(i);

            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                int pop = stack.pop();
                k--;
            }

            stack.push(num);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        System.out.println(sb);
    }
}
