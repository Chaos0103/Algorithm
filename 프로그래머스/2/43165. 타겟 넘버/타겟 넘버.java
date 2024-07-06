class Solution {
    
    private int result;
    
    private void dfs(int[] numbers, int calc, int target, int depth) {
        if (numbers.length == depth) {
            if (target == calc) {
                result++;
            }
            return;
        }
        
        dfs(numbers, calc + numbers[depth], target, depth + 1);
        dfs(numbers, calc - numbers[depth], target, depth + 1);
    }
    
    public int solution(int[] numbers, int target) {
        result = 0;
        dfs(numbers, 0, target, 0);
        return result;
    }
}