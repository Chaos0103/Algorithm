import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        String line = fr.nextLine();

        Stack<Character> s = new Stack<>();
        List<Character> result = new ArrayList<>();
        for (char ch : line.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                result.add(ch);
            } else {
                if (ch == '(') {
                    s.push(ch);
                } else if (ch == '*' || ch == '/') {
                    while (!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')) {
                        result.add(s.pop());
                    }
                    s.push(ch);
                } else if (ch == '+' || ch == '-') {
                    while (!s.isEmpty() && s.peek() != '(') {
                        result.add(s.pop());
                    }
                    s.push(ch);
                } else if (ch == ')') {
                    while (!s.isEmpty() && s.peek() != '(') {
                        result.add(s.pop());
                    }
                    s.pop();
                }
            }
        }

        while (!s.isEmpty()) {
            result.add(s.pop());
        }

        for (Character ch : result) {
            System.out.print(ch);
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}