import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> count = new HashSet<>();
        for (int num : nums) {
            count.add(num);
        }

        return Math.min(count.size(), nums.length / 2);
    }
}