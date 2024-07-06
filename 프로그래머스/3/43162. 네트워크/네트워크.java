class Solution {
    
    private void dfs(int[][] computers, boolean[] isVisited, int num) {
        isVisited[num] = true;
        for (int i = 0; i < isVisited.length; i++) {
            if (computers[num][i] == 1 && !isVisited[i]) {
                dfs(computers, isVisited, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int result = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(computers, isVisited, i);
                result++;
            }
        }
        
        return result;
    }
}