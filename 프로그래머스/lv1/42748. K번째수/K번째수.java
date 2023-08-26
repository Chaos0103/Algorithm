import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> result = new ArrayList<>();

        for (int[] command : commands) {
            List<Integer> number = new ArrayList<>();

            int start = command[0];
            int end = command[1];
            int target = command[2];

            for (int i = start - 1; i < end; i++) {
                number.add(array[i]);
            }

            Collections.sort(number);
            result.add(number.get(target - 1));
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}