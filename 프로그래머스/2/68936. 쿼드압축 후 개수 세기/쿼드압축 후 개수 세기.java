class Solution {
    
    private static int[] result;
    
    private int func(int[][] arr, int y, int x, int n) {
        if (n == 1) {
            int num = arr[y][x];
            result[num]++;
            return num;
        }
        
        int a = func(arr, y, x, n / 2); 
        int b = func(arr, y + n / 2, x, n / 2);
        int c = func(arr, y, x + n / 2, n / 2);
        int d = func(arr, y + n / 2, x + n / 2, n / 2);
        
        if (a == 0 && b == 0 && c == 0 && d == 0) {
            result[0] -= 3;
            return 0;
        }
        
        if (a == 1 && b == 1 && c == 1 && d == 1) {
            result[1] -= 3;
            return 1;
        }
        
        return -1;
    }
    
    public int[] solution(int[][] arr) {
        result = new int[2];
        func(arr, 0, 0, arr.length);
        
        return result;
    }
}