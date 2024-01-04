import java.io.*;
import java.util.Stack;

public class Main {

    private static boolean isVPS(String target) {
        Stack<String> stack = new Stack<>();
        for (char c : target.toCharArray()) {
            if (c == '(') {
                stack.push(String.valueOf(c));
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            stack.pop();
        }

        return stack.empty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            String result = isVPS(str) ? "YES" : "NO";

            builder.append(result).append("\n");
        }

        bw.write(builder.toString());
        bw.flush();
        bw.close();
    }
}