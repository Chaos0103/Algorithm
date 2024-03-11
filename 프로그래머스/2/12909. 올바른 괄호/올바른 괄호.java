import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(')');
                continue;
            } else if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            return false;
        }
        
        return stack.isEmpty();
    }
}