import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] split = s.split("},\\{");
        Arrays.sort(split, Comparator.comparingInt(String::length));

        List<Integer> result = new ArrayList<>();
        for (String str : split) {
            String[] data = str.split(",");
            for (String num : data) {
                if (!result.contains(Integer.parseInt(num))) {
                    result.add(Integer.parseInt(num));
                }
            }
        }

        return result.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}