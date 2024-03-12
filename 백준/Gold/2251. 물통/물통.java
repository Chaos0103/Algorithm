import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Integer> solution(int[] size) {
        Set<Integer> result = new HashSet<>();
        boolean[][][] isVisited = new boolean[size[0] + 1][size[1] + 1][size[2] + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, size[2]});

        while (!q.isEmpty()) {
            int[] bucket = q.poll();

            if (bucket[0] == 0) {
                result.add(bucket[2]);
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    int[] next = new int[3];
                    int min = Math.min(bucket[i], size[(i + 1) % 3] - bucket[(i + 1) % 3]);
                    next[i] = bucket[i] - min;
                    next[(i + 1) % 3] = bucket[(i + 1) % 3] + min;
                    next[(i + 2) % 3] = bucket[(i + 2) % 3];
                    if (!isVisited[next[0]][next[1]][next[2]]) {
                        q.add(next);
                        isVisited[next[0]][next[1]][next[2]] = true;
                    }
                }
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] init = new int[3];
        for (int i = 0; i < 3; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = solution(init);
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
