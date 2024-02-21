import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }

        int status = 0;
        int time = 0;
        int index = 0;
        while (!q.isEmpty()) {
            time++;

            int front = q.poll();
            status -= front;

            if (index >= truck_weights.length) {
                continue;
            }

            int now = truck_weights[index];
            if (status + now <= weight) {
                index++;
                q.add(now);
                status += now;
            } else {
                q.add(0);
            }
        }

        return time;
    }
}