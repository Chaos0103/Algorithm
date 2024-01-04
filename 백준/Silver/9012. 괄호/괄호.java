import java.util.*;

public class Main {

    private static Stack<Character> stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String result = "YES";
            stack = new Stack<>();
            for (char ch : str.toCharArray()) {
                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                result = "NO";
            }
            System.out.println(result);
        }
    }
}