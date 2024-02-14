import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : before.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        for (char c : after.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            if (count == 0) {
                return 0;
            }
            map.put(c, count - 1);
        }

        return 1;
    }
}