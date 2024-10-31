import java.util.*;

class Solution {
    private List<Integer> camera = new ArrayList<>();

    private boolean isInCamera(int[] route) {
        for (int p : camera) {
            if (route[0] <= p && p <= route[1]) {
                return true;
            }
        }
        return false;
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int[] route : routes) {
            if (isInCamera(route)) {
                continue;
            }
            camera.add(route[1]);
        }

        return camera.size();
    }
}