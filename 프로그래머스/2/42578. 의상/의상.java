import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            int count = map.getOrDefault(cloth[1], 0);
            map.put(cloth[1], count + 1);
        }
        
        int answer = 1; 
        for (String type : map.keySet()) {
            answer *= map.get(type) + 1;
        }
        
        return answer - 1;
    }
}