import java.util.*;

class Solution {
    
    private int result;
    
    private void dfs(String[] words, boolean[] isVisited, String begin, String target, int depth) {
        if (begin.equals(target)) {
            result = Math.min(result, depth);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!isVisited[i] && isPossible(begin, words[i])) {
                isVisited[i] = true;
                dfs(words, isVisited, words[i], target, depth + 1);
                isVisited[i] = false;
            }
        }
    }
    
    private boolean isPossible(String word, String target) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        result = 100;
        dfs(words, new boolean[words.length], begin, target, 0);
        return result == 100 ? 0 : result;
    }
}