import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (list.isEmpty()) {
                list.add(num);
                continue;
            }
            if (list.get(list.size() - 1) != num) {
                list.add(num);
            }
        }

        return list.stream()
            .mapToInt(integer -> integer)
            .toArray();
    }
}