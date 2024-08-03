import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Point implements Comparable<Point> {
        public long x;
        public long a;

        public Point(long x, long a) {
            this.x = x;
            this.a = a;
        }

        @Override
        public int compareTo(Point o) {
            if (x < o.x) {
                return -1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return "Point{" +
                "x=" + x +
                ", a=" + a +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            points[i] = new Point(x, a);
            sum += a;
        }

        Arrays.sort(points);

        long mid = (sum + 1) / 2;
        long left = 0;
        for (int i = 0; i < n; i++) {
            left += points[i].a;
            if (left >= mid) {
                System.out.println(points[i].x);
                return;
            }
        }
    }
}

