class Solution {
    
    private int target;
    
    private int dfs(int[] numbers, int calc, int depth) {
        if (depth == numbers.length) {
            if (calc == target) {
                return 1;
            }
            return 0;
        }
        
        return dfs(numbers, calc + numbers[depth], depth + 1)
        + dfs(numbers, calc - numbers[depth], depth + 1);
    }
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        
        return dfs(numbers, 0, 0);
    }
}