import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<List<Pair>> combinations;

    private static class Pair {
        public int open;
        public int close;

        public Pair(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    private static void comb(List<Pair> pairs, int[] ans, boolean[] isVisited, int index, int depth, int n) {
        if (depth == n) {
            List<Pair> temp = new ArrayList<>();
            for (int i : ans) {
                temp.add(pairs.get(i));
            }
            combinations.add(temp);
            return;
        }

        for (int i = index; i < pairs.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                ans[depth] = i;
                comb(pairs, ans, isVisited, i + 1, depth + 1, n);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<Pair> pairs = new ArrayList<>();

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                s.push(i);
            } else if (ch == ')') {
                int open = s.pop();
                pairs.add(new Pair(open, i));
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= pairs.size(); i++) {
            combinations = new ArrayList<>();
            comb(pairs, new int[i], new boolean[pairs.size()], 0, 0, i);

            for (List<Pair> combination : combinations) {
                boolean[] check = new boolean[str.length()];
                for (Pair pair : combination) {
                    check[pair.open] = true;
                    check[pair.close] = true;
                }

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    if (check[j]) {
                        continue;
                    }
                    sb.append(str.charAt(j));
                }
                result.add(sb.toString());
            }
        }

        result.stream()
            .distinct()
            .sorted()
            .forEach(System.out::println);
    }
}