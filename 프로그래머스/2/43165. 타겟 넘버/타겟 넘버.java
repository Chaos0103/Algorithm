class Solution {
    
    private int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0, numbers, 0, target);
        return answer;
    }
    
    private void dfs(int result, int[] numbers, int depth, int target) {
        if (depth == numbers.length) {
            if (result == target) {
                answer++;
            }
            return;
        }
        
        dfs(result + numbers[depth], numbers, depth + 1, target);
        dfs(result - numbers[depth], numbers, depth + 1, target);
    }
}