import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class DoublePriorityQueue {
        private static final PriorityQueue<Problem> high = new PriorityQueue<>((a, b) -> {
            if (b.level == a.level) {
                return b.no - a.no;
            }
            return b.level - a.level;
        });
        private static final PriorityQueue<Problem> low = new PriorityQueue<>((a, b) -> {
            if (a.level == b.level) {
                return a.no - b.no;
            }
            return a.level - b.level;
        });
        private static final Map<Integer, Integer> problemMap = new HashMap<>();

        public void add(int no, int level) {
            Problem problem = new Problem(no, level);
            high.add(problem);
            low.add(problem);
            problemMap.put(no, level);
        }

        public void solved(int no) {
            problemMap.remove(no);
        }

        public int recommend(int x) {
            if (x == 1) {
                while (!high.isEmpty()) {
                    Problem problem = high.peek();
                    if (problemMap.getOrDefault(problem.no, 0) == problem.level) {
                        return problem.no;
                    }
                    high.poll();
                }
            }

            if (x == -1) {
                while (!low.isEmpty()) {
                    Problem problem = low.peek();
                    if (problemMap.getOrDefault(problem.no, 0) == problem.level) {
                        return problem.no;
                    }
                    low.poll();
                }
            }

            return -1;
        }
    }

    private static class Problem {
        public int no;
        public int level;

        public Problem(int no, int level) {
            this.no = no;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DoublePriorityQueue dpq = new DoublePriorityQueue();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            dpq.add(no, level);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if ("add".equals(cmd)) {
                int no = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                dpq.add(no, level);
            } else if ("solved".equals(cmd)) {
                int no = Integer.parseInt(st.nextToken());
                dpq.solved(no);
            } else if ("recommend".equals(cmd)) {
                int x = Integer.parseInt(st.nextToken());
                int no = dpq.recommend(x);
                System.out.println(no);
            }
        }
    }
}