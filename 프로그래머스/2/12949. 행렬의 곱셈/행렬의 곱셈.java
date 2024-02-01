class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int y = 0; y < answer.length; y++) {
            for (int x = 0; x < answer[0].length; x++) {
                for (int i = 0; i < arr1[y].length; i++) {
                    answer[y][x] += arr1[y][i] * arr2[i][x];                    
                }
            }
        }
        return answer;
    }
}