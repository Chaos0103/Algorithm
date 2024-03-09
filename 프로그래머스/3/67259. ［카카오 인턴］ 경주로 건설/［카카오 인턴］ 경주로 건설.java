import java.util.*;

class Solution {
    
    private static final int INF = (int) 1e9;
    private static final int[][] DISTANCES = {{-1, 0, 0}, {0, 1, 1}, {1, 0, 2}, {0, -1, 3}};
    
    private static class Point {
        public int x;
        public int y;
        public int cost;
        public int distance;
        
        public Point(int x, int y, int cost, int distance) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.distance = distance;
        }
    }
    
    private int getMinimumCost(int[][] board, int n) {
        int result = INF;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, -1));
        
        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.x == n - 1 && point.y == n - 1 && result > point.cost) {
                result = point.cost;
            }
            for (int i = 0; i < 4; i++) {
                int ny = point.y + DISTANCES[i][0];
                int nx = point.x + DISTANCES[i][1];
                int add = point.distance == DISTANCES[i][2] || point.distance == -1 ? 1 : 6;
                
                if (!(0 <= ny && ny < n && 0 <= nx && nx < n)) {
                    continue;
                }
                
                if (board[ny][nx] == 1) {
                    continue;
                }
                
                if (dp[ny][nx] < point.cost + add - 4) {
                    continue;
                }
                
                dp[ny][nx] = point.cost + add;
                q.add(new Point(nx, ny, point.cost + add, DISTANCES[i][2]));
            }
        }
        
        return result * 100;
    }
    
    public int solution(int[][] board) {
        return getMinimumCost(board, board.length);
    }
}