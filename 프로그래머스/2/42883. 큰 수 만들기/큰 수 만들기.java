import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        int size = number.length() - k;
        Stack<Integer> s = new Stack<>();

        char[] arr = number.toCharArray();
        for (int i = 0; i < arr.length; i++) {


            int num = arr[i] - '0';
            if (s.isEmpty() || k == 0) {
                s.push(num);
                continue;
            }

            while (num > s.peek()) {
                s.pop();
                k--;
                if (s.isEmpty() || k == 0) {
                    break;
                }
            }

            if (s.size() == size) {
                continue;
            }

            s.push(num);
        }

        return s.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}