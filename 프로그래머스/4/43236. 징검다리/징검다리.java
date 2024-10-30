import java.util.Arrays;

class Solution {
    private int isValid(int mid, int distance, int[] rocks) {
        int remove = 0;
        int now = 0;
        for (int rock : rocks) {
            if (rock - now >= mid) {
                now = rock;
                continue;
            }
            remove++;
        }

        if (distance - now < mid) {
            remove++;
        }
        return remove;
    }

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValid(mid, distance, rocks) == n) {
                answer = mid;
                left = mid + 1;
            } else if (isValid(mid, distance, rocks) > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }
}