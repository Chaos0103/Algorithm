import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int result = 0;

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                s.add(arr[i]);
                continue;
            }

            s.pop();
            if (arr[i - 1] == '(') {
                result += s.size();
            } else {
                result += 1;
            }
        }

        System.out.println(result);
    }
}