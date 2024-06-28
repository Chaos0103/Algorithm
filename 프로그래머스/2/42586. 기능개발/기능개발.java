import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        
        int day = 1;
        int count = 0;
        while (!q.isEmpty()) {
            int index = q.peek();
        
            if (progresses[index] + speeds[index] * day >= 100) {
                q.poll();
                count++;
            } else {
                if (count > 0) {
                    result.add(count);    
                    count = 0;
                }
                day++;
            }
        }
        
        result.add(count);
        
        return result.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}