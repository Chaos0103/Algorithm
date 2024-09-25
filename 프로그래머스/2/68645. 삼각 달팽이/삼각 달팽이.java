class Solution {
    
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, -1}};
    
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        
        int d = 0;
        int[] p = new int[]{0, 0};
        for (int i = 1; i <= sum; i++) {
            arr[p[0]][p[1]] = i;
            int ny = p[0] + directions[d][0];
            int nx = p[1] + directions[d][1];
            if (!(0 <= ny && ny < n && 0 <= nx && nx < n)) {
                d++;
            } else if (arr[ny][nx] > 0) {
                d++;
            }
            d %= 3;
            p[0] += directions[d][0];
            p[1] += directions[d][1];
        }
        
        int index = 0;
        int[] answer = new int[sum];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0) {
                    answer[index++] = arr[i][j];
                }
            }
        }
        return answer;
    }
}