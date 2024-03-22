import java.util.*;

class Solution {
    public String[] solution(String[] record) {    
        Map<String, String> users = new HashMap<>();
        for (String str : record) {
            String[] data = str.split(" ");
            if (data.length == 3) {
                users.put(data[1], data[2]);    
            }
        }
        
        List<String> result = new ArrayList<>();
        for (String str : record) {
            String[] data = str.split(" ");
            if (data[0].equals("Enter")) {
                result.add(users.get(data[1]) + "님이 들어왔습니다.");
            } else if (data[0].equals("Leave")) {
                result.add(users.get(data[1]) + "님이 나갔습니다.");
            }
        }

        return result.toArray(String[]::new);
    }
}