import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.contains(city)) {
                answer += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                cache.add(city);
                if (cache.size() > cacheSize) {
                    cache.poll();
                }
            }
        }
        
        return answer;
    }
}