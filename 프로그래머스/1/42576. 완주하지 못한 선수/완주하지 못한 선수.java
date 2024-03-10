import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> player = new HashMap<>();
        for (String name : completion) {
            int count = player.getOrDefault(name, 0);
            player.put(name, count + 1);
        }
        
        String answer = "";
        for (String name : participant) {
            int count = player.getOrDefault(name, 0);
            if (count == 0) {
                answer = name;
                break;
            }
            player.put(name, count - 1);
        }
        
        return answer;
    }
}