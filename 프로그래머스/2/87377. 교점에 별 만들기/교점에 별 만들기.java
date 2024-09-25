import java.util.*;

class Solution {
    private boolean hasUniquePoint(long a, long b, long c, long d) {
        long calc = a * d - b * c;
        return calc != 0;
    }
    
    private int[] calculateCrossPoint(long a, long b, long e, long c, long d, long f) {
        long x = (b * f - e * d) / (a * d - b * c);
        long y = (e * c - a * f) / (a * d - b * c);
        if ((b * f - e * d) % (a * d - b * c) != 0 || (e * c - a * f) % (a * d - b * c) != 0) {
            return null;
        }
        return new int[]{(int) x, (int) y};
    }
    
    public String[] solution(int[][] line) {
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if (hasUniquePoint(line[i][0], line[i][1], line[j][0], line[j][1])) {
                    int[] point = calculateCrossPoint(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                    if (point != null) {
                        points.add(point);    
                    }
                }
            }
        }
        
        int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int[] point : points) {
            max[0] = Math.max(max[0], point[0]);
            max[1] = Math.max(max[1], point[1]);
            min[0] = Math.min(min[0], point[0]);
            min[1] = Math.min(min[1], point[1]);
        }
        
        char[][] board = new char[max[1] - min[1] + 1][max[0] - min[0] + 1];
        for (int[] point : points) {
        
            board[point[1] - min[1]][point[0] - min[0]] = '*';
        }
        
        String[] answer = new String[board.length];
        for (int i = 0; i < board.length; i++) {
            String temp = "";
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[board.length - 1 - i][j];
                if (ch != '*') {
                    ch = '.';
                }
                temp += ch;
            }
            answer[i] = temp;
        }
        
        return answer;
    }
}