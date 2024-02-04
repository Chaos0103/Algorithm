import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> {
                int n1 = Integer.parseInt(s1 + s2);
                int n2 = Integer.parseInt(s2 + s1);
                return n2 - n1;
            })
            .collect(Collectors.joining(""))
            .replaceAll("^0+", "0");
    }
}