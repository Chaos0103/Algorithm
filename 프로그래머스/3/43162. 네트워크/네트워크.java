import java.util.*;

class Solution {
    
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited);    
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int start, boolean[] isVisited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        isVisited[start] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < graph.get(node).size(); i++) {
                int next = graph.get(node).get(i);
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}