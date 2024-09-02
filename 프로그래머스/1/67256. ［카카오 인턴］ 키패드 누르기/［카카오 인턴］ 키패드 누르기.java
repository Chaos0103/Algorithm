import java.util.Set;

class Solution {

    private static final int[][] NUMBERS = {
        {3, 1},
        {0, 0}, {0, 1}, {0, 2},
        {1, 0}, {1, 1}, {1, 2},
        {2, 0}, {2, 1}, {2, 2},
    };
    private Point left;
    private Point right;
    private String mainHand;

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

    private String getFinger(int num) {
        if (Set.of(1, 4, 7).contains(num)) {
            return "L";
        }

        if (Set.of(3, 6, 9).contains(num)) {
            return "R";
        }

        int leftDistance = calculateDistance(NUMBERS[num], left);
        int rightDistance = calculateDistance(NUMBERS[num], right);

        if (leftDistance < rightDistance) {
            return "L";
        }

        if (leftDistance > rightDistance) {
            return "R";
        }

        return mainHand;
    }

    public String solution(int[] numbers, String hand) {
        mainHand = "left".equals(hand) ? "L" : "R";
        left = new Point(3, 0);
        right = new Point(3, 2);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            String finger = getFinger(number);

            int[] p = NUMBERS[number];
            if ("L".equals(finger)) {
                left = new Point(p[0], p[1]);
            } else {
                right = new Point(p[0], p[1]);
            }
            sb.append(finger);
        }

        return sb.toString();
    }
}