import java.util.ArrayList;

class Solution {

    private static final int[][] arr = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int max = 0;
        int[] count = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == arr[i][j % arr[i].length]) {
                    count[i]++;
                }
            }
            max = Math.max(max, count[i]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == count[i]) {
                answer.add(i + 1);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}