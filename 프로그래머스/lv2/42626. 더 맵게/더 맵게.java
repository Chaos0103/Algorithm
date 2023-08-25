import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int num : scoville) {
            q.offer(num);
        }

        int answer = 0;
        while (q.peek() < K) {
            if (q.size() == 1) {
                return -1;
            }

            answer++;
            int first = q.poll();
            int second = q.poll();

            q.offer(first + second * 2);
        }

        return answer;
    }
}