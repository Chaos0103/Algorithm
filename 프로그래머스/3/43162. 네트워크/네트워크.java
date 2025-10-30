import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i, graph);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(boolean[] isVisited, int current, List<List<Integer>> graph) {
        for (int i = 0; i < graph.get(current).size(); i++) {
            if (!isVisited[graph.get(current).get(i)]) {
                isVisited[graph.get(current).get(i)] = true;
                dfs(isVisited, graph.get(current).get(i), graph);
            }
        }
    }
}