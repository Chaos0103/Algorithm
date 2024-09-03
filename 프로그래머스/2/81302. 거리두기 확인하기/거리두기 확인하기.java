import java.util.*;

class Solution {
    
    private static final int[][] d = {{0, 1},  {0, -1}, {1, 0}, {-1, 0}};
    
    private int valid(char[][] map, int y, int x) {
        boolean[][] isVisited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x, 0});
        isVisited[y][x] = true;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p[0] + d[i][0];
                int nx = p[1] + d[i][1];
                
                if (!(0 <= ny && ny < 5 && 0 <= nx && nx < 5)) {
                    continue;
                }
                
                if (map[ny][nx] == 'X' || isVisited[ny][nx]) {
                    continue;
                }
                
                if (map[ny][nx] == 'P') {
                    return 0;
                }
                
                if (p[2] + 1 == 2) {
                    continue;
                }
                isVisited[ny][nx] = true;
                q.offer(new int[]{ny, nx, p[2] + 1});
            }
        }
        return 1;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        
        int index = 0;
        for (String[] place : places) {
            char[][] room = new char[5][5];
            for (int i = 0; i < place.length; i++) {
                room[i] = place[i].toCharArray();
            }
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (room[i][j] == 'P') {
                        int result = valid(room, i, j);
                        answer[index] = result;
                    }
                    
                    if (answer[index] == 0) {
                        break;
                    }
                }
                
                if (answer[index] == 0) {
                    break;
                }
            }
            index++;
        }
        
        return answer;
    }
}