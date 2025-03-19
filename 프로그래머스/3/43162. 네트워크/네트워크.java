class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(computers, isVisited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, boolean[] isVisited, int no) {
        isVisited[no] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[no][i] == 1 && !isVisited[i]) {
                dfs(computers, isVisited, i);
            }
        }
    }
}