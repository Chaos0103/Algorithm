import java.util.*;

class Solution {
    
    private final List<List<Integer>> network = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) {
            network.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            network.get(wires[i][0]).add(wires[i][1]);
            network.get(wires[i][1]).add(wires[i][0]);
        }
        
        int answer = n;
        for (int[] wire : wires) {
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] isVisited = new boolean[n + 1];
            q.offer(1);
            isVisited[1] = true;
            
            int count = 0;
            while (!q.isEmpty()) {
                int no = q.poll();
                count++;
                for (int i = 0; i < network.get(no).size(); i++) {
                    if (isVisited[network.get(no).get(i)]) {
                        continue;
                    }
                    
                    if ((no == wire[0] && network.get(no).get(i) == wire[1])
                       || (no == wire[1] && network.get(no).get(i) == wire[0])) {
                           continue;
                       }
                    q.offer(network.get(no).get(i));
                    isVisited[network.get(no).get(i)] = true;
                }
            }
            
            answer = Math.min(answer, Math.abs(n - count * 2));
        }
        
        return answer;
    }
}