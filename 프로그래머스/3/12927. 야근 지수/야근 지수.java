import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int work : works) {
            pq.add(work);
        }

        for(int i = 0; i < n; i++) {
            int work = pq.poll();
            pq.add(work - 1);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            if (work <= 0) {
                continue;
            }
            answer += work * work;
        }

        return answer;
    }
}