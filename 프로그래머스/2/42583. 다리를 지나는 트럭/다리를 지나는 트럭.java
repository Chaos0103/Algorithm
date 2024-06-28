import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> q = new LinkedList<>();
        for (int i  = 0; i < bridgeLength; i++) {
            q.add(0);
        }
        
        int index = 0;
        int sec = 0;
        int total = 0;
        while (index < truckWeights.length || 0 < total) {
            int next = 0;
            if (index < truckWeights.length && total + truckWeights[index] - q.peek() <= weight) {
                next = truckWeights[index];
                total += truckWeights[index];
                index++;
            }
            
            q.add(next);
            int elem = q.poll();
            if (elem > 0) {
                total -= elem;
            }
            
            sec++;
        }
        
        return sec;
    }
}