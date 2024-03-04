import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Conference implements Comparable<Conference> {
        public int start;
        public int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if (end == o.end) {
                return start - o.start;
            }
            return end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Conference[] conferences = new Conference[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conferences[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(conferences);

        int currentEndTime = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            Conference conference = conferences[i];
            if (currentEndTime <= conference.start) {
                currentEndTime = conference.end;
                result++;
            }
        }

        System.out.println(result);
    }
}