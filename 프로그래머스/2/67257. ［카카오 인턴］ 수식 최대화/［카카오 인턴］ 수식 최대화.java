import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    private static final String[][] operations = {
        "*-+".split(""),
        "*+-".split(""),
        "-*+".split(""),
        "-+*".split(""),
        "+*-".split(""),
        "+-*".split("")
    };

    private List<String> generateToken(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "*-+", true);
        List<String> results = new ArrayList<>();
        while (st.hasMoreTokens()) {
            results.add(st.nextToken());
        }
        return results;
    }

    private long calculate(List<String> tokens, int index) {
        String[] operation = operations[index];
        for (String op : operation) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    Long a = Long.parseLong(tokens.get(i - 1));
                    Long b = Long.parseLong(tokens.get(i + 1));
                    long result = 0L;
                    if ("+".equals(op)) {
                        result = a + b;
                    } else if ("-".equals(op)) {
                        result = a - b;
                    } else if ("*".equals(op)) {
                        result = a * b;
                    }
                    tokens.remove(i + 1);
                    tokens.remove(i);
                    tokens.remove(i - 1);

                    tokens.add(i - 1, Long.toString(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    public long solution(String expression) {
        List<String> tokens = generateToken(expression);

        long answer = 0;
        for (int i = 0; i < operations.length; i++) {
            long calculate = calculate(new ArrayList<>(tokens), i);
            answer = Math.max(answer, Math.abs(calculate));
        }

        return answer;
    }
}