import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        List<List<Integer>> network = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            network.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    network.get(i).add(j);
                }
            }
        }
        
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                bfs(network, isVisited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(List<List<Integer>> network, boolean[] isVisited, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        isVisited[start] = true;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < network.get(now).size(); i++) {
                if (!isVisited[network.get(now).get(i)]) {
                    q.offer(network.get(now).get(i));
                    isVisited[network.get(now).get(i)] = true;
                }
            }
        }
    }
}