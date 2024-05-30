import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothesInfo : clothes) {
            int count = map.getOrDefault(clothesInfo[1], 0);
            map.put(clothesInfo[1], count + 1);
        }
        
        int answer = 1;
        for (String name : map.keySet()) {
            int count = map.get(name);
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}
