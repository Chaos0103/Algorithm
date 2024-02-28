import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[][] DIRECTION = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Point {
        public int x;
        public int y;
        public int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    private char[][] toArray(String[] place) {
        char[][] arr = new char[5][5];
        for (int i = 0; i < 5; i++) {
            arr[i] = place[i].toCharArray();
        }
        return arr;
    }

    private boolean isCorrect(char[][] room) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (room[i][j] == 'P' && !isValid(room, j, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] room, int x, int y) {
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(x, y, 0));
        while (!points.isEmpty()) {
            Point point = points.poll();

            if (point.depth >= 2) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = point.x + DIRECTION[i][0];
                int ny = point.y + DIRECTION[i][1];

                if (nx == x && ny == y) {
                    continue;
                }

                if (!(0 <= nx && nx < 5 && 0 <= ny && ny < 5)) {
                    continue;
                }

                if (room[ny][nx] == 'P') {
                    return false;
                }

                if (room[ny][nx] == 'O') {
                    points.add(new Point(nx, ny, point.depth + 1));
                }
            }
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            char[][] room = toArray(places[i]);

            answer[i] = isCorrect(room) ? 1 : 0;
        }

        return answer;
    }
}