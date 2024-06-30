import java.util.*;

class Solution {
    private static final List<List<Integer>> graph = new ArrayList<>();
    
    private int count(int n, int[] remove) {
        boolean[] isVisited = new boolean[n + 1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVisited[1] = true;
        
        while (!q.isEmpty()) {
            int elem = q.poll();
            for (int i = 0; i < graph.get(elem).size(); i++) {
                if (isVisited[graph.get(elem).get(i)] ||
                    (elem == remove[0] && graph.get(elem).get(i) == remove[1]) ||
                   (elem == remove[1] && graph.get(elem).get(i) == remove[0])) {
                    continue;
                }
                q.add(graph.get(elem).get(i));
                isVisited[graph.get(elem).get(i)] = true;
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) {
                count++;
            }
        }
        
        return Math.abs(n - count * 2);
    }
    
    public int solution(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int result = 1000;
        for (int[] wire : wires) { 
            int count = count(n, wire);
            result = Math.min(result, count);
        }
        
        return result;
    }
}