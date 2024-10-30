class Solution {
    private long calculate(int[] times, long total) {
        long result = 0L;
        for (int time : times) {
            result += total / time;
        }
        return result;
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = 1000000000000000000L;
        while (left < right) {
            long mid = (left + right) / 2;
            long result = calculate(times, mid);
            if (result >= n) {
                right = mid;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}