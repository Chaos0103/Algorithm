class Solution {

    private String target;
    private String[] words;
    private int answer;

    private void dfs(String now, boolean[] isVisited, int depth) {
        if (target.equals(now)) {
            answer = depth;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!isVisited[i] && isPossible(now, words[i])) {
                isVisited[i] = true;
                dfs(words[i], isVisited, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private boolean isPossible(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        answer = 0;

        dfs(begin, new boolean[words.length], 0);
        
        return answer;
    }
}