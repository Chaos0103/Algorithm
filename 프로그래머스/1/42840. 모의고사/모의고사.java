import java.util.*;

class Solution {
    private static final int[][] WAYS = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    public int[] solution(int[] answers) {
        int[] counts = new int[3];
        
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int[] way = WAYS[i];
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == way[j % way.length]) {
                    counts[i]++;
                }
            }
            max = Math.max(max, counts[i]);
        }
        
        List<Integer> results = new ArrayList<>();        
        for (int i = 0; i < 3; i++) {
            if (max == counts[i]) {
                results.add(i + 1);
            }
        }
        return results.stream()
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}