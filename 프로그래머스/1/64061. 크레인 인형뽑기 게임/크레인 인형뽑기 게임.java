import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

class Solution {

    private static final List<Stack<Integer>> boards = new ArrayList<>();
    private static final Stack<Integer> basket = new Stack<>();

    public int solution(int[][] board, int[] moves) {
        for (int i = 0; i < board.length; i++) {
            boards.add(new Stack<>());
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] > 0) {
                    boards.get(j).add(board[i][j]);
                }
            }
        }

        int answer = 0;

        for (int move : moves) {
            if (boards.get(move - 1).isEmpty()) {
                continue;
            }

            if (!basket.isEmpty() && Objects.equals(boards.get(move - 1).peek(), basket.peek())) {
                answer += 2;
                basket.pop();
                boards.get(move - 1).pop();
                continue;
            }

            basket.add(boards.get(move - 1).pop());
        }

        return answer;
    }
}