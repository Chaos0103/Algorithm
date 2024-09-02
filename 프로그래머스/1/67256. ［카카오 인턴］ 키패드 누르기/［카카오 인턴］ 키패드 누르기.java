import java.util.*;

class Solution {
    
    private static final int[][] NUMBERS = {
        {3, 1},
        {0, 0}, {0, 1}, {0, 2},
        {1, 0}, {1, 1}, {1, 2},
        {2, 0}, {2, 1}, {2, 2},
    };
    private static Point left;
    private static Point right;
    
    private static class Point {
        public int y;
        public int x;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    private int calculateDistance(int[] arr, Point p) {
        return Math.abs(arr[0] - p.y) + Math.abs(arr[1] - p.x);
    }
    
    public String solution(int[] numbers, String hand) {
        left = new Point(3, 0);
        right = new Point(3, 2);
        
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            int[] p = NUMBERS[number];
            if (List.of(1, 4, 7).contains(number)) {
                left = new Point(p[0], p[1]);
                sb.append("L");
            } else if (List.of(3, 6, 9).contains(number)) {
                right = new Point(p[0], p[1]);
                sb.append("R");
            } else {
                int leftDistance = calculateDistance(p, left);
                int rightDistance = calculateDistance(p, right);
                if (leftDistance < rightDistance) {
                    left = new Point(p[0], p[1]);
                    sb.append("L");
                } else if (leftDistance > rightDistance) {
                    right = new Point(p[0], p[1]);
                    sb.append("R");
                } else {
                    if ("left".equals(hand)) {
                        left = new Point(p[0], p[1]);
                        sb.append("L");
                    } else {
                        right = new Point(p[0], p[1]);
                        sb.append("R");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}