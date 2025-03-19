class Solution {
    
    private int result;
    
    public int solution(int k, int[][] dungeons) {
        result = 0;
        comb(dungeons, new boolean[dungeons.length], new int[dungeons.length], k, 0);
        return result;
    }
    
    private void comb(int[][] dungeons, boolean[] isVisited, int[] seq, int k, int depth) {
        if (depth == dungeons.length) {
            int kt = k;
            for (int i = 0; i < seq.length; i++) {
                if (kt < dungeons[seq[i]][0]) {
                    result = Math.max(result, i);
                    return;
                }
                kt -= dungeons[seq[i]][1];
            }
            result = dungeons.length;
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                seq[depth] = i;
                comb(dungeons, isVisited, seq, k, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}