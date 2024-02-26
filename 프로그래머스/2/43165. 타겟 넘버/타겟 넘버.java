import java.util.ArrayList;
import java.util.List;

class Solution {

    private final List<Integer> results = new ArrayList<>();

    private void dfs(int[] numbers, int depth, int value) {
        if (depth == numbers.length) {
            results.add(value);
            return;
        }
        dfs(numbers, depth + 1, value + numbers[depth]);
        dfs(numbers, depth + 1, value - numbers[depth]);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0);
        return (int) results.stream()
            .filter(i -> i == target)
            .count();
    }
}