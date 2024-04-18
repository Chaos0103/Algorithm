import java.util.*;

class Solution {
    //2x2가 같은 캐릭터인 경우 블록을 부실 수 있다.
    //다 부신 후 블록을 아래로 내린다.
    //다시 반복한다.
    private static final char BLANK = '.';
    
    private boolean isBreak(char[][] board, int y, int x) {
        char standard = board[y][x];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (board[y + i][x + j] == BLANK) {
                    return false;
                }
                
                if (board[y + i][x + j] != standard) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean[][] getBreakInfo(char[][] board, int m, int n) {
        boolean[][] isBreak = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (isBreak(board, i, j)) {
                    isBreak[i][j] = true;
                    isBreak[i + 1][j] = true;
                    isBreak[i][j + 1] = true;
                    isBreak[i + 1][j + 1] = true;
                }
            }
        }
        
        return isBreak;
    }
    
    private void down(char[][] board, int m, int n) {
        for (int x = 0; x < n; x++) {
            for (int y = m - 1; y >= 0; y--) {
                if (board[y][x] == BLANK) {
                    int index = getIndex(board, y, x);
                    if (index == -1) {
                        break;
                    }
                    board[y][x] = board[index][x];
                    board[index][x] = BLANK;
                }
            }
        }
    }
    
    private int getIndex(char[][] board, int y, int x) {
        for (int i = y; i >= 0; i--) {
            if (board[i][x] != BLANK) {
                return i;
            }
        }
        return -1;
    }
    
    public int solution(int m, int n, String[] boardData) {
        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            board[i] = boardData[i].toCharArray();
        }
        
        int answer = 0;
        int count = 1;
        while (count > 0) {
            count = 0;
            
            boolean[][] isBreak = getBreakInfo(board, m, n);
        
            for (int i = 0; i < m ; i++) { 
                for (int j = 0; j < n; j++) {
                    if (isBreak[i][j]) {
                        count++;
                        board[i][j] = BLANK;
                    }
                }
            }
            
            down(board, m, n);
            
            answer += count;
        }
        
        return answer;
    }
}