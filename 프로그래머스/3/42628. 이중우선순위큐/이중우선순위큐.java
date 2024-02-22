import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> min = new PriorityQueue<>();

        int size = 0;
        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String cmd = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (cmd.equals("I")) {
                max.add(value);
                min.add(value);
                size++;
                continue;
            }

            if (size == 0) {
                continue;
            }

            if (value == 1) {
                max.poll();
            } else {
                min.poll();
            }
            size--;

            if (size == 0) {
                max.clear();
                min.clear();
            }
        }

        int maxValue = size == 0 ? 0 : max.poll();
        int minValue = size == 0 ? 0 : min.poll();

        return new int[]{maxValue, minValue};
    }
}

class ASDS {
    public static void main(String[] args) {
        int[] solution = new Solution().solution(new String[]{"I 1", "I 2", "D 1", "D -1", "I 3", "I 4", "D 1"});
        System.out.println(Arrays.toString(solution));
    }
}