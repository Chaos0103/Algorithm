import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> s = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                sb.append(ch);
                continue;
            }

            if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty()) {
                    char pop = s.pop();
                    if (pop == '(') {
                        break;
                    }
                    sb.append(pop);
                }
            } else if (ch == '+' || ch == '-') {
                if (s.isEmpty()) {
                    s.push(ch);
                    continue;
                }

                while (!s.isEmpty()) {
                    char pop = s.pop();
                    if (pop == '(') {
                        s.push(pop);
                        break;
                    }
                    sb.append(pop);
                }

                s.push(ch);
            } else if (ch == '*' || ch == '/') {
                if (s.isEmpty()) {
                    s.push(ch);
                    continue;
                }

                while (!s.isEmpty()) {
                    char pop = s.pop();
                    if (pop == '(' || pop == '+' || pop == '-') {
                        s.push(pop);
                        break;
                    }
                    sb.append(pop);
                }

                s.push(ch);
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        System.out.println(sb);
    }
}