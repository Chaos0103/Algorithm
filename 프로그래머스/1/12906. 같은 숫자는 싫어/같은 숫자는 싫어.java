import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.add(arr[0]);
        
        for (int element : arr) {
            if (s.peek() == element) {
                continue;
            }    
            s.add(element);
        }

        return s.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}