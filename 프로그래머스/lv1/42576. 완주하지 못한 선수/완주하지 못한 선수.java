import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String name : completion) {
            int cnt = count.getOrDefault(name, 0);
            count.put(name, cnt + 1);
        }

        String answer = "";
        for (String name : participant) {
            int cnt = count.getOrDefault(name, 0);
            if (cnt == 0) {
                answer = name;
                break;
            }
            count.put(name, cnt - 1);
        }

        return answer;
    }
}