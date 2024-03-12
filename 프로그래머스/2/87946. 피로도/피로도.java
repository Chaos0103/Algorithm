import java.util.*;

class Solution {
    
    private static int result = 0;
    
    private void perm(int[][] dungeons, int[][] out, boolean[] isVisited, int depth, int k) {
        if (depth == dungeons.length) {
            int count = 0;
            for (int[] dungeon : out) {
                if (k < dungeon[0]) {
                    break;
                }
                k -= dungeon[1];
                count++;
            }
            result = Math.max(result, count);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                out[depth] = dungeons[i];
                perm(dungeons, out, isVisited, depth + 1, k);
                isVisited[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        perm(dungeons, new int[dungeons.length][2], new boolean[dungeons.length], 0, k);
        return result;
    }
}