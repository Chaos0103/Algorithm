import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
class Node {
    private int index;
    private int height;

    public Node(int index, int height) {
        this.index = index;
        this.height = height;
    }

    public int getIndex() {
        return index;
    }

    public int getHeight() {
        return height;
    }
}
public class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }

        int[] result = new int[n];
        Stack<Node> s = new Stack<>();
        s.push(new Node(n - 1, top[n - 1]));
        for (int i = n - 2; i >= 0; i--) {
            int height = top[i];
            while (!s.isEmpty() && s.peek().getHeight() <= height) {
                Node node = s.pop();
                result[node.getIndex()] = i + 1;
            }
            s.push(new Node(i, top[i]));
        }


        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
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