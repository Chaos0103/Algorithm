import java.util.*;

class Solution {
    
    private void calc(int cap, int[] arr, int index) {
        while (index >= 0) {
            if (cap >= arr[index]) {
                cap -= arr[index];
                arr[index--] = 0;
            } else {
                arr[index] -= cap;
                break;
            }
        }
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int i = n - 1;
        while (i >= 0) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                i--;
                continue;
            }
            
            calc(cap, deliveries, i);
            calc(cap, pickups, i);
            
            answer += (i + 1) * 2;
        }
    
        return answer;
    }
}