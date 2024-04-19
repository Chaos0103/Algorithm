import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private static final Map<String, Integer> dictionary = new HashMap<>();
    private static int count = 0;

    private void init() {
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            dictionary.put(String.valueOf(ch), ++count);
        }
    }

    public int[] solution(String msg) {
        init();

        List<Integer> result = new ArrayList<>();

        StringBuilder sub = new StringBuilder();
        int start = 0;
        for (int i = 0; i < msg.length(); i++) {
            sub.append(msg.charAt(i));
            int index = dictionary.getOrDefault(sub.toString(), 0);
            if (index == 0) {
                dictionary.put(sub.toString(), ++count);
                result.add(dictionary.get(sub.substring(0, sub.length() - 1)));
                sub = new StringBuilder();
                sub.append(msg.charAt(i));
                start = i;
            }
        }

        result.add(dictionary.get(msg.substring(start)));

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}