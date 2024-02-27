import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static class Node {
        public String word;
        public int count;

        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    private boolean isPossible(String current, String word) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));

        boolean[] isVisited = new boolean[words.length];
        while (!q.isEmpty()) {
            Node node = q.poll();
            String word = node.word;
            int count = node.count;

            if (word.equals(target)) {
                answer = count;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (!isVisited[i] && isPossible(word, words[i])) {
                    isVisited[i] = true;
                    q.add(new Node(words[i], count + 1));
                }
            }
        }

        return answer;
    }

}