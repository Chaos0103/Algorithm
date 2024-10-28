class Solution {
    
    private int target;
    private int answer;
    
    private void dfs(int[] numbers, int calc, int depth) {
        if (depth == numbers.length) {
            if (calc == target) {
                answer++;
            }
            return;
        }
        
        dfs(numbers, calc + numbers[depth], depth + 1);
        dfs(numbers, calc - numbers[depth], depth + 1);
    }
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        answer = 0;
        
        dfs(numbers, 0, 0);
        
        return answer;
    }
}