import java.util.*;

class Solution {
    
    private static final List<int[]> result = new ArrayList<>();
    
    private void hanoi(int n, int from, int to) {
        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }
        
        int mid = 6 - from - to;
        hanoi(n - 1, from, mid);
        hanoi(1, from, to);
        hanoi(n - 1, mid, to);
    }
    
    public int[][] solution(int n) {
        hanoi(n, 1, 3);
        
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}