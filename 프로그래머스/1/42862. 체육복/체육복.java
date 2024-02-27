import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] arr = new boolean[n + 2];
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]] = true;
        }
        Arrays.sort(lost);
        for (int i = 0; i < lost.length; i++) {
            int index = lost[i];
            if (arr[index]) {
                lost[i] = -1;
            }
            arr[index] = false;
        }

        int count = 0;
        for (int i = 0; i < lost.length; i++) {
            int index = lost[i];
            if (lost[i] == -1) {
                continue;
            }

            if (arr[index - 1]) {
                arr[index - 1] = false;
            } else if (arr[index + 1]) {
                arr[index + 1] = false;
            } else {
                count++;
            }
        }

        return n - count;
    }
}