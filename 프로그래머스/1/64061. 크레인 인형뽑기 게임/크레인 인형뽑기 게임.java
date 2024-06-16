import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] > 0) {
                    int dall = board[i][move - 1];
                    board[i][move - 1] = 0;
                    if (!basket.isEmpty() && basket.peek() == dall) {
                        answer += 2;
                        basket.pop();
                    } else {
                        basket.add(dall);
                    }

                    break;
                }
            }
        }

        return answer;
    }
}