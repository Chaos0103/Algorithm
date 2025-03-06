class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int calc, int depth) {
        if (depth == numbers.length) {
            if (calc == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, target, calc + numbers[depth], depth + 1) 
            + dfs(numbers, target, calc - numbers[depth], depth + 1);
    }
}