import java.util.ArrayList;
import java.util.List;

class Solution {
    //좌표를 저장할 클래스
    private static class Point {
        public long x;
        public long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    //1. 교점을 구하기
    private Point calculateCrossPoint(int[] line1, int[] line2) {
        long a = line1[0];
        long b = line1[1];
        long e = line1[2];
        long c = line2[0];
        long d = line2[1];
        long f = line2[2];
        double x = (double) (b * f - e * d) / (a * d - b * c);
        double y = (double) (e * c - a * f) / (a * d - b * c);
        //2. 교점이 정수인 경우 저장하기
        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    public String[] solution(int[][] line) {
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;

        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point point = calculateCrossPoint(line[i], line[j]);
                if (point != null) {
                    points.add(point);
                    //3. x, y축 최댓값, 최솟값 구하기
                    maxX = Math.max(maxX, point.x);
                    minX = Math.min(minX, point.x);

                    maxY = Math.max(maxY, point.y);
                    minY = Math.min(minY, point.y);
                }
            }
        }

        //4. 별 찍을 배열 생성
        boolean[][] star = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        //5. 별 찍기
        for (Point point : points) {
            star[(int) (point.y - minY)][(int) (point.x - minX)] = true;
        }

        //6. String 배열로 변환
        String[] answer = new String[star.length];
        for (int i = 0; i < star.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < star[i].length; j++) {
                if (star[i][j]) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            answer[answer.length - i - 1] = sb.toString();
        }

        return answer;
    }
}