import java.util.*;

class Solution {
    
    private static final int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private static class Point {
        public int y;
        public int x;
        public int count;
        
        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
    
    private int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] isVisited = new boolean[n][m];
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        isVisited[0][0] = true;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == n - 1 && p.x == m - 1) {
                return p.count;
            }
            
            for (int i = 0; i < 4; i++) {
                int ny = p.y + d[i][0];
                int nx = p.x + d[i][1];
                
                if (!(0 <= ny && ny < n && 0 <= nx && nx < m)) {
                    continue;
                }
                
                if (maps[ny][nx] == 0 || isVisited[ny][nx]) {
                    continue;
                }
                
                isVisited[ny][nx] = true;
                q.add(new Point(ny, nx, p.count + 1));
            }
        }
        
        return -1;
    }
    
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}