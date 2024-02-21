import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) {
                day++;
            }
            queue.add(day);
        }

        int count = 1;
        int prev = queue.poll();
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int day = queue.poll();
            if (prev >= day) {
                count++;
                continue;
            }

            answer.add(count);
            count = 1;
            prev = day;
        }
        
        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}