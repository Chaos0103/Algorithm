import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[index] < B[i]) {
                answer++;
                index++;
            }
        }
        
        return answer;
    }
}