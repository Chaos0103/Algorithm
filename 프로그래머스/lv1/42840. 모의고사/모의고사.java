import java.util.ArrayList;
import java.util.List;

class Solution {

    public final int[][] arr = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] count = {0, 0, 0};

        for (int i = 0; i < 3; i++) {
            int length = arr[i].length;
            for (int j = 0; j < answers.length; j++) {
                if (arr[i][j % length] == answers[j]) {
                    count[i]++;
                }
            }    
        }

        int maxCount = 0; 
        for (int i = 0; i < 3; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (count[i] == maxCount) {
                result.add(i + 1);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}