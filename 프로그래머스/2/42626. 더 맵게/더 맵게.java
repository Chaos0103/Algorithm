import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int value : scoville) {
            pq.add(value);
        }
        
        int answer = 0;
        while (pq.size() >= 2) {
            if (pq.peek() >= K) {
                break;
            }
            
            int value1 = pq.poll();
            int value2 = pq.poll();
            int result = value1 + value2 * 2;
            pq.add(result);
            answer++;
        }
        
        return pq.peek() >= K ? answer : -1;
    }
}