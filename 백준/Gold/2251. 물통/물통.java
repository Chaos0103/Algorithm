import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Set<Integer> solution(int a, int b, int c) {
        Set<Integer> result = new HashSet<>();
        boolean[][][] isVisited = new boolean[a + 1][b + 1][c + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, c});

        int[] size = {a, b, c};
        while (!q.isEmpty()) {
            int[] bucket = q.poll();
            if (bucket[0] == 0) {
                result.add(bucket[2]);
            }
            for (int i = 0; i < 3; i++) {
                int[] next = new int[3];
                int t = Math.min(bucket[i], size[(i + 1) % 3] - bucket[(i + 1) % 3]);
                next[i] = bucket[i] - t;
                next[(i + 1) % 3] = bucket[(i + 1) % 3] + t;
                next[(i + 2) % 3] = bucket[(i + 2) % 3];
                if (!isVisited[next[0]][next[1]][next[2]]) {
                    q.add(next);
                    isVisited[next[0]][next[1]][next[2]] = true;
                }

                next = new int[3];
                int r = Math.min(bucket[i], size[(i + 2) % 3] - bucket[(i + 2) % 3]);
                next[i] = bucket[i] - r;
                next[(i + 1) % 3] = bucket[(i + 1) % 3];
                next[(i + 2) % 3] = bucket[(i + 2) % 3] + r;
                if (!isVisited[next[0]][next[1]][next[2]]) {
                    q.add(next);
                    isVisited[next[0]][next[1]][next[2]] = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] init = new int[3];
        for (int i = 0; i < 3; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> result = solution(init[0], init[1], init[2]);
        ArrayList<Integer> s = new ArrayList<>(result);
        Collections.sort(s);
        for (int num : s) {
            System.out.print(num + " ");
        }
    }
}
