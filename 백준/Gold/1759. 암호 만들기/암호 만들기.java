import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int l;
    private static final List<String> results = new ArrayList<>();
    private static final Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');

    private static void comb(char[] arr, boolean[] isVisited, int start, int depth) {
        if (depth == l) {
            StringBuilder sb = new StringBuilder();
            int vowelCount = 0;
            for (int i = 0; i < arr.length; i++) {
                if (isVisited[i]) {
                    sb.append(arr[i]);
                    if (vowel.contains(arr[i])) {
                        vowelCount++;
                    }
                }
            }
            if (vowelCount >= 1 && (sb.length() - vowelCount) >= 2) {
                results.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                comb(arr, isVisited, i + 1, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[] arr = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        comb(arr, new boolean[arr.length], 0, 0);

        StringBuilder sb = new StringBuilder();
        for (String result : results) {
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}