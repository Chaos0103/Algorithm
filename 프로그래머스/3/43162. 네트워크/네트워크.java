import java.util.*;

class Solution {
    private void bfs(int start, int[][] computers, boolean[] isVisited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        
        while (!q.isEmpty()) {
            int computer = q.poll();
            
            for (int i = 0; i < computers[computer].length; i++) {
                if (computers[computer][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !isVisited[i]) {
                    bfs(i, computers, isVisited);
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
}