import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<int[]> q = new ArrayDeque<>();
        boolean[] isVisited = new boolean[200_001];
        q.offer(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            if (!(0 <= poll[0] && poll[0] < isVisited.length)) {
                continue;
            }

            if (poll[0] == k) {
                System.out.println(poll[1]);
                return;
            }

            if (isVisited[poll[0]]) {
                continue;
            }

            isVisited[poll[0]] = true;
            q.offerFirst(new int[]{poll[0] * 2, poll[1]});
            q.offerLast(new int[]{poll[0] + 1, poll[1] + 1});
            q.offerLast(new int[]{poll[0] - 1, poll[1] + 1});
        }
    }
}