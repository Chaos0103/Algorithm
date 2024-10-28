class Solution {
    
    private void dfs(int[][] computer, boolean[] isVisited, int no) {
        isVisited[no] = true;
        for (int i = 0; i < computer[no].length; i++) {
            if (i == no) {
                continue;
            }
            
            if (computer[no][i] == 1 && !isVisited[i]) {
                dfs(computer, isVisited, i);
            }
        }
    }
    
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
}