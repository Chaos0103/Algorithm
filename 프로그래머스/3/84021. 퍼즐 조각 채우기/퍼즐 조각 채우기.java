import java.util.*;

class Solution {
    
    private final int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int solution(int[][] gameBoard, int[][] table) {
        List<List<int[]>> blanks = findPieces(gameBoard, 0);
        
        
        List<List<int[]>> puzzles = findPieces(table, 1);
        
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer += match(blanks, puzzles);
            puzzles = turn(puzzles);
        }
        
        return answer;
    }
    
    private List<List<int[]>> turn(List<List<int[]>> puzzles) {
        List<List<int[]>> result = new ArrayList<>();
        for (List<int[]> puzzle : puzzles) {
            for (int[] arr : puzzle) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp * -1;
            }
            List<int[]> after = changeStandard(puzzle); 
            after.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            result.add(after);
        }
        
        return result;
    }
    
    private int match(List<List<int[]>> blanks, List<List<int[]>> puzzles) {
        int count = 0;
        for (int i = blanks.size() - 1; i >= 0; i--) {
            for (int j = puzzles.size() - 1; j >= 0; j--) {
                if (isMatches(blanks.get(i), puzzles.get(j))) {
                    count += blanks.get(i).size();
                    blanks.remove(i);
                    puzzles.remove(j);
                    break;
                }
            }
        }
        
        return count;
    }
    
    private boolean isMatches(List<int[]> p1, List<int[]> p2) {
        if (p1.size() != p2.size()) {
            return false;
        }
        
        for (int i = 0; i < p1.size(); i++) {
            if (!(p1.get(i)[0] == p2.get(i)[0] && p1.get(i)[1] == p2.get(i)[1])) {
                return false;
            }
        }
        
        return true;
    }

    private List<List<int[]>> findPieces(int[][] arr, int target) {
        List<List<int[]>> result = new ArrayList<>();
        
        boolean[][] isVisited = new boolean[arr.length][arr.length];
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr.length; x++) {
                if (!isVisited[y][x] && arr[y][x] == target) {
                    List<int[]> piece = findPiece(arr, isVisited, y, x, target);
                    piece = changeStandard(piece);
                    result.add(piece);
                }
            }
        }
        
        return result;
    }
    
    private List<int[]> changeStandard(List<int[]> piece) {
        int minY = 50;
        int minX = 50;
        
        //좌표 최솟값 찾기
        for (int i = 0; i < piece.size(); i++) {
            minY = Math.min(minY, piece.get(i)[0]);
            minX = Math.min(minX, piece.get(i)[1]);
        }
        
        //순회하며 최솟값 빼기
        for (int i = 0; i < piece.size(); i++) {
            piece.get(i)[0] -= minY;
            piece.get(i)[1] -= minX;
        }
        
        return piece;
    }
    
    private List<int[]> findPiece(int[][] arr, boolean[][] isVisited, int y, int x, int target) {
        List<int[]> piece = new ArrayList<>();
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        isVisited[y][x] = true;
        piece.add(new int[]{y, x});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + d[i][0];
                int nx = now[1] + d[i][1];
                
                if (!(0 <= ny && ny < arr.length && 0 <= nx && nx < arr.length)) {
                    continue;
                }
                
                if (isVisited[ny][nx] || arr[ny][nx] != target) {
                    continue;
                }
                
                q.offer(new int[]{ny, nx});
                isVisited[ny][nx] = true;
                piece.add(new int[]{ny, nx});
            }
        }
        
        piece.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        return piece;
    }
}