import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : scoville) {
            pq.add(num);
        }
        
        int count = 0;
        while(!pq.isEmpty()) {
            int first = pq.poll();
            
            if (first >= K) {
                break;
            }
            
            if (pq.isEmpty()) {
                return -1;
            }
            
            int second = pq.poll();
            int temp = first + second * 2;
            pq.add(temp);
            count++;
        }

        return count;
    }
}