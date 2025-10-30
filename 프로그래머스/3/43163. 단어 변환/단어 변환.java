class Solution {
    
    private int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 100;
        dfs(begin, target, words, new boolean[words.length], 0);
        return answer == 100 ? 0 : answer;
    }
    
    private void dfs(String from, String target, String[] words, boolean[] isUsed, int depth) {
        if (from.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!isUsed[i] && isPossible(from, words[i])) {
                isUsed[i] = true;
                dfs(words[i], target, words, isUsed, depth + 1);
                isUsed[i] = false;
            }
        }
    }
    
    private boolean isPossible(String from, String target) {
        int count = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}