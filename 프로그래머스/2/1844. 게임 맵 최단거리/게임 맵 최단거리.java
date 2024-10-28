import java.util.*;

class Solution {
    
    private int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        isVisited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == maps.length - 1 && p[1] == maps[0].length - 1) {
                return p[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + d[i][0];
                int nx = p[1] + d[i][1];
                
                if(!(0 <= ny && ny < maps.length && 0 <= nx && nx < maps[0].length)) {
                    continue;
                }
                
                if (isVisited[ny][nx] || maps[ny][nx] == 0) {
                    continue;
                }
                
                q.offer(new int[]{ny, nx, p[2] + 1});
                isVisited[ny][nx] = true;
            }
        }
        
        return -1;
    }
}