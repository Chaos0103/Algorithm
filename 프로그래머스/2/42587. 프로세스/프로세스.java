import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static class Process {
        public int index;
        public int priority;

        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(new Process(i, priorities[i]));
        }

        int answer = 1;
        while (!q.isEmpty()) {
            Process process = q.poll();
            if (process.priority == pq.peek()) {
                if (process.index == location) {
                    break;
                }
                pq.poll();
                answer++;
                continue;
            }

            q.add(process);
        }

        return answer;
    }
}