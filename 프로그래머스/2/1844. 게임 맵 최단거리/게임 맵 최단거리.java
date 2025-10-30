import java.util.*;

class Solution {
    
    private final int[][] D = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    private int bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        isVisited[0][0] = true;
        q.offer(new int[]{0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == maps.length - 1 && p[1] == maps[0].length - 1) {
                return p[2];
            }
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + D[i][0];
                int nx = p[1] + D[i][1];
                
                if (!(0 <= ny && ny < maps.length && 0 <= nx && nx < maps[0].length)) {
                    continue;
                }
                
                if (isVisited[ny][nx] || maps[ny][nx] != 1) {
                    continue;
                }
                
                isVisited[ny][nx] = true;
                q.offer(new int[]{ny, nx, p[2] + 1});
            }
        }
        
        return -1;
    }
}