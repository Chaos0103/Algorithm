import java.util.*;

class Solution {
    private int run(Deque<Integer>[] board, int[] moves) {
        int result = 0;
        Deque<Integer> basket = new ArrayDeque<>();
        
        for (int i = 0; i < moves.length; i++) {
            int index = moves[i] - 1;
            if (board[index].isEmpty()) {
                continue;
            }
        
            int no = board[index].pop();
            if (basket.isEmpty() || basket.peek() != no) {
                basket.push(no);
                continue;
            }
            
            basket.pop();
            result += 2;
        }
        
        return result;
    }
    
    public int solution(int[][] board, int[] moves) {
        int n = board[0].length;
        
        Deque<Integer>[] s = new Deque[n];
        for (int i = 0; i < n; i++) {
            s[i] = new ArrayDeque<>();
        }
        
        for (int i = board.length - 1; i >= 0; i--) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    s[j].push(board[i][j]);    
                }
            }
        }
        
        return run(s, moves);
    }
}