import java.util.*;

class Solution {
    
    private static final List<List<Integer>> graph = new ArrayList<>();
    
    private void bfs(int start, boolean[] isVisited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            int num = q.poll();
            isVisited[num] = true;
            for (int i = 0; i < graph.get(num).size(); i++) {
                int next = graph.get(num).get(i);
                if (isVisited[next]) {
                    continue;
                }
                q.add(next);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        boolean[] isVisited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited);
                result++;
            }
        }
        return result;
    }
}