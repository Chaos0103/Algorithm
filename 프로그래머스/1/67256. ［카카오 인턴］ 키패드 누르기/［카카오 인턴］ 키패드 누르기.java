class Solution {
    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final Point[] numberPoints = new Point[10];
    private Point left = new Point(0, 3);
    private Point right = new Point(2, 3);

    private void initNumberPoint() {
        numberPoints[0] = new Point(1, 3);
        int index = 1;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                numberPoints[index++] = new Point(x, y);
            }
        }
    }

    private String move(Point point, String hand) {
        int leftDistance = calcDistance(point, left);
        int rightDistance = calcDistance(point, right);
        String result;
        if (leftDistance > rightDistance) {
            right = point;
            result = "R";
        } else if (leftDistance < rightDistance) {
            left = point;
            result = "L";
        } else {
            if (hand.equals("right")) {
                right = point;
                result = "R";
            } else {
                left = point;
                result = "L";
            }
        }
        return result;
    }

    private int calcDistance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public String solution(int[] numbers, String hand) {
        initNumberPoint();

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            Point point = numberPoints[number];
            if (number % 3 == 2 || number == 0) {
                String move = move(point, hand);
                sb.append(move);
            } else if (number % 3 == 1) {
                left = point;
                sb.append("L");
            } else {
                right = point;
                sb.append("R");
            }
        }
        return sb.toString();
    }
}