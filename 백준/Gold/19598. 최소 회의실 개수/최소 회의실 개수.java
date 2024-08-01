import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Time implements Comparable<Time> {
        public int s;
        public int e;

        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Time o) {
            if (s == o.s) {
                return e - o.e;
            }
            return s - o.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times[i] = new Time(s, e);
        }

        Arrays.sort(times);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times[0].e);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= times[i].s) {
                pq.poll();
            }
            pq.offer(times[i].e);
        }

        System.out.println(pq.size());
    }
}