import java.util.*;

class Solution {
    
    private static final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] isVisited = new boolean[n][m];
        
        return bfs(maps, n, m, isVisited);
    }
    
    private int bfs(int[][] maps, int n, int m, boolean[][] isVisited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        isVisited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == n - 1 && p[1] == m - 1) {
                return p[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = D[i][0] + p[0];
                int nx = D[i][1] + p[1];
                
                if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                    continue;
                }
                
                if (isVisited[ny][nx] || maps[ny][nx] == 0) {
                    continue;
                }
                
                isVisited[ny][nx] = true;
                q.offer(new int[]{ny, nx, p[2] + 1});
            }
        }
        
        return -1;
    }
}